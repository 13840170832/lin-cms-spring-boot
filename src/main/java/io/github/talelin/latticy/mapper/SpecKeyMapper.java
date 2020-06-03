package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SpecKeyDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SpecKeyDetailDO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-29
 */
public interface SpecKeyMapper extends BaseMapper<SpecKeyDO> {

    List<SpecKeyDO> getBySpuId(Long spuId);

    SpecKeyDetailDO getDetail(Long id);
}
