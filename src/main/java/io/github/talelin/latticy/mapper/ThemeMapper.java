package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.ThemeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.ThemeDetailDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-06-01
 */
public interface ThemeMapper extends BaseMapper<ThemeDO> {

    ThemeDetailDO getDetail(Long id);
}
