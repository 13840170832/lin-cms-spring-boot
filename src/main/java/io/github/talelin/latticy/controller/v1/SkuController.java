package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.SkuDTO;
import io.github.talelin.latticy.model.SkuDetailDO;
import io.github.talelin.latticy.service.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.SkuDO;
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
@RequestMapping("/v1/sku")
@Validated
public class SkuController {

    @Autowired
    private SkuService skuService;

    @PostMapping
    public CreatedVO create(@RequestBody @Validated SkuDTO dto) {
        SkuDO sku = new SkuDO();
        BeanUtils.copyProperties(dto,sku);
        skuService.save(sku);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated SkuDTO dto,
            @PathVariable @Positive Long id) {
        skuService.updateSku(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        skuService.deleteSku(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SkuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        return null;
    }

    @GetMapping("/{id}/detail")
    public SkuDetailDO getDetail(@PathVariable @Positive Long id){
        return skuService.getSkuDetail(id);
    }

    @GetMapping("/by/spu/{id}")
    public List<SkuDO> getBySpuId(@PathVariable(value="id") @Positive Long spuId){
        return this.skuService.lambdaQuery().eq(SkuDO::getSpuId,spuId).list();
    }

    @GetMapping("/page")
    public PageResponseVO<SkuDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        Page<SkuDO> pager = new Page<>(page,count);
        IPage<SkuDO> paging = skuService.page(pager);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

}
