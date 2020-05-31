package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.dto.BannerItemDTO;
import io.github.talelin.latticy.service.BannerItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-05-31
*/
@RestController
@RequestMapping("/v1/banner-item")
@Api(tags = "Banner管理")
public class BannerItemController {

    @Autowired
    private BannerItemService bannerItemService;

    @PostMapping
    @ApiOperation(value="添加BannerItem",notes = "添加BannerItem")
    public CreatedVO create(@RequestBody @Validated BannerItemDTO dto) {
        BannerItemDO bannerItem = new BannerItemDO();
        BeanUtils.copyProperties(dto,bannerItem);
        bannerItemService.save(bannerItem);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    @ApiOperation(value="更新BannerItem")
    public UpdatedVO update(@RequestBody @Validated BannerItemDTO dto,
                            @PathVariable @Positive Long id) {
        bannerItemService.update(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BannerItem")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        bannerItemService.delete(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="BannerItem详情")
    public BannerItemDO get(@PathVariable @Positive Long id) {
        return bannerItemService.getById(id);
    }

}
