package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SpecKeyDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

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
}
