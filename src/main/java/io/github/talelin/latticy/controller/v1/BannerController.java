package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.LoginRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
@PermissionModule(value = "Banner")
@Api(tags = "Banner管理")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping
    @PermissionMeta(value = "创建Banner")
    @GroupRequired
    @ApiOperation(value="添加Banner",notes = "添加Banner")
    public CreatedVO createBanner(@RequestBody @Validated BannerDTO dto){
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(dto,bannerDO);
        bannerService.save(bannerDO);
        return new CreatedVO();
    }

    @PutMapping("{id}")
    @PermissionMeta(value = "更新Banner")
    @GroupRequired
    @ApiOperation(value="更新Banner",notes = "查看Banner,修改")
    public UpdatedVO update(@RequestBody @Validated BannerDTO bannerDTO,
                    @PathVariable @Positive Long id){
        bannerService.update(bannerDTO,id);
        return new UpdatedVO();
    }

    @DeleteMapping("{id}")
    @PermissionMeta(value = "删除Banner")
    @GroupRequired
    @ApiOperation(value="删除Banner",notes = "Banner列表-删除")
    public DeletedVO delete(@PathVariable @Positive Long id){
        bannerService.delete(id);
        return new DeletedVO();
    }

    @GetMapping("{id}")
    @LoginRequired
    @ApiOperation(value="Banner详情",notes = "查看Banner")
    public BannerWithItemsBO get(@PathVariable @Positive Long id){
        return bannerService.getBannerWithItems(id);
    }

    @GetMapping("/page")
    @LoginRequired
    @ApiOperation(value="Banner列表",notes = "Banner列表")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false,defaultValue = "0")
                           @Min(value=0) Integer page,
                                               @RequestParam(required = false,defaultValue = "10")
                           @Min(value = 0,message = "{page.count.min}") @Max(value=30,message = "{page.count.max}") Integer count){
        Page<BannerDO> pager = new Page<>(page,count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager,null);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }
}
