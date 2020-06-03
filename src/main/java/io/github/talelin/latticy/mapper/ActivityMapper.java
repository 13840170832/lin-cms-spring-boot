package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.ActivityDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.ActivityDetailDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-23
 */
public interface ActivityMapper extends BaseMapper<ActivityDO> {

    ActivityDetailDO getDetail(Long id);
}
