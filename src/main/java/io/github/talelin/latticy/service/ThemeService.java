package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.GridCategoryDTO;
import io.github.talelin.latticy.dto.ThemeDTO;
import io.github.talelin.latticy.mapper.ThemeMapper;
import io.github.talelin.latticy.model.GridCategoryDO;
import io.github.talelin.latticy.model.ThemeDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.ThemeDetailDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-06-01
 */
@Service
public class ThemeService extends ServiceImpl<ThemeMapper,ThemeDO> {

    public ThemeDO getThemeById(Long id){
        ThemeDO theme = this.getById(id);
        if(null == theme){
            throw new NotFoundException(80000);
        }
        return theme;
    }

    public ThemeDetailDO getThemeDetailById(Long id){
        return this.getBaseMapper().getDetail(id);
    }

    public void updateTheme(ThemeDTO dto, Long id){
        ThemeDO theme = this.getThemeById(id);
        BeanUtils.copyProperties(dto,theme);
        theme.setUpdateTime(new Date());
        this.updateById(theme);
    }

    public void deleteTheme(Long id){
        ThemeDO theme = this.getById(id);
        this.getBaseMapper().deleteById(id);
    }
}
