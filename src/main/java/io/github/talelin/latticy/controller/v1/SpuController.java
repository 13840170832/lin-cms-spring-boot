package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.PageList;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.model.SpuDetailDO;
import io.github.talelin.latticy.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.util.List;

/**
* @author generator@TaleLin
* @since 2020-05-27
*/
@RestController
@RequestMapping("/v1/spu")
@Validated
@Api(tags = "Spu管理")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @PostMapping("")
    public CreatedVO create(@RequestBody @Validated SpuDTO dto) {
        spuService.create(dto);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated SpuDTO dto,
            @PathVariable @Positive Long id) {
        spuService.update(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        spuService.deleteSpu(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SpuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        return null;
    }

    @GetMapping("/{id}/detail")
    public SpuDetailDO getDetail(@PathVariable(value="id") @Positive(message = "{id.positive}") Long id){
        return spuService.getDetail(id);
    }

    @GetMapping("/page")
    public PageResponseVO<SpuDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        Page<SpuDO> pager = new Page<>(page,count);
        IPage<SpuDO> paging = spuService.lambdaQuery().page(pager);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

    @GetMapping("/by/theme/{id}")
    @ApiOperation(value = "选择主题对应的Spu")
    public List<SpuDO> getListForTheme(@PathVariable @Positive Long id){
        return spuService.getSpuForTheme(id);
    }

    @GetMapping("/not/in/{id}")
    @ApiOperation(value = "选择Sku对应的Spu")
    public List<SpuDO> getListForSku(@PathVariable @Positive Long id){
        return spuService.lambdaQuery().ne(SpuDO::getId,id).list();
    }

}
