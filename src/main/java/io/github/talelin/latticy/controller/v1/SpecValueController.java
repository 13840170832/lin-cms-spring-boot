package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.dto.SpecValueDTO;
import io.github.talelin.latticy.service.SpecValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.SpecValueDO;
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
@RequestMapping("/v1/spec-value")
public class SpecValueController {

    @Autowired
    private SpecValueService specValueService;

    @PostMapping
    public CreatedVO create(@RequestBody @Validated SpecValueDTO dto) {
        SpecValueDO value = new SpecValueDO();
        BeanUtils.copyProperties(dto,value);
        specValueService.save(value);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated SpecValueDTO dto,
                            @PathVariable @Positive Long id) {
        specValueService.updateSpecValue(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        specValueService.deleteSpecValue(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SpecValueDO get(@PathVariable @Positive Long id) {
        SpecValueDO value = specValueService.getSpecValue(id);
        return value;
    }

    @GetMapping("/by/key/{id}")
    public List<SpecValueDO> getValueByKey(@PathVariable @Positive Long id){
        return specValueService.lambdaQuery()
                .eq(SpecValueDO::getSpecId,id).list();
    }

}
