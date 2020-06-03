package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.autoconfigure.exception.ParameterException;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.mapper.ThemeMapper;
import io.github.talelin.latticy.mapper.ThemeSpuMapper;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.model.ThemeDO;
import io.github.talelin.latticy.model.ThemeSpuDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-06-01
 */
@Service
public class ThemeSpuService extends ServiceImpl<ThemeSpuMapper,ThemeSpuDO> {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private SpuService spuService;

    public void createThemeSpu(Integer themeId,Integer spuId){
        ThemeDO theme = themeService.getById(themeId);
        if(null == theme){
            throw new NotFoundException(80000);
        }
        SpuDO spu = spuService.getById(spuId);
        if(null == spu){
            throw new NotFoundException(50000);
        }
        ThemeSpuDO themeSpuDO = this.lambdaQuery()
                .eq(ThemeSpuDO::getThemeId,themeId)
                .eq(ThemeSpuDO::getSpuId,spuId).one();
        if(null != themeSpuDO){
            throw new ParameterException(80001);
        }

        themeSpuDO = new ThemeSpuDO();
        themeSpuDO.setThemeId(themeId)
                .setSpuId(spuId);
        this.save(themeSpuDO);
    }

}
