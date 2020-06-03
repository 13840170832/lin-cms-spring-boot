package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.SpecKeyDTO;
import io.github.talelin.latticy.model.SpecKeyDetailDO;
import io.github.talelin.latticy.service.SpecKeyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.SpecKeyDO;
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
* @since 2020-05-29
*/
@RestController
@RequestMapping("/v1/spec-key")
public class SpecKeyController {

    @Autowired
    private SpecKeyService specKeyService;

    @PostMapping
    public CreatedVO create(@RequestBody @Validated SpecKeyDTO dto) {
        SpecKeyDO spec = new SpecKeyDO();
        BeanUtils.copyProperties(dto,spec);
        specKeyService.save(spec);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated SpecKeyDTO dto,
                            @PathVariable @Positive Long id) {
        specKeyService.updateSpecKey(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        specKeyService.deleteSpec(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SpecKeyDO get(@PathVariable @Positive Long id) {
        return specKeyService.getSpecKeyById(id);
    }

    @GetMapping("/{id}/detail")
    public SpecKeyDetailDO getDetail(@PathVariable @Positive Long id){
        return specKeyService.getDetail(id);
    }

    @GetMapping("/by/spu/{id}")
    public List<SpecKeyDO> getBySpuId(@PathVariable(value="id") @Positive Long spuId){
        return this.specKeyService.getBySpuId(spuId);
    }

    @GetMapping("/page")
    public PageResponseVO<SpecKeyDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        Page<SpecKeyDO> pager = new Page<>(page,count);
        IPage<SpecKeyDO> paging = specKeyService.page(pager);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

}
