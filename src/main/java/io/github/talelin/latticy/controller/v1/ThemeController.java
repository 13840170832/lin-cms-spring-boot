package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.ThemeDTO;
import io.github.talelin.latticy.model.ThemeDetailDO;
import io.github.talelin.latticy.service.ThemeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.ThemeDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-06-01
*/
@RestController
@RequestMapping("/v1/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @PostMapping
    public CreatedVO create(@RequestBody @Validated ThemeDTO dto) {
        ThemeDO theme = new ThemeDO();
        BeanUtils.copyProperties(dto,theme);
        this.themeService.save(theme);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated ThemeDTO dto,
                        @PathVariable @Positive Long id) {
        themeService.updateTheme(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        themeService.deleteTheme(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public ThemeDO get(@PathVariable @Positive Long id) {
        return themeService.getThemeById(id);
    }

    @GetMapping("/{id}/detail")
    public ThemeDetailDO getDetail(@PathVariable @Positive Long id) {
        return themeService.getThemeDetailById(id);
    }

    @GetMapping("/page")
    public PageResponseVO<ThemeDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        Page<ThemeDO> pager = new Page<>();
        IPage<ThemeDO> paging = themeService.page(pager);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

}
