package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SkuDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SkuDetailDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-27
 */
public interface SkuMapper extends BaseMapper<SkuDO> {

    SkuDetailDO getDetail(Long id);
}
