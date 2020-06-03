package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.ActiveDTO;
import io.github.talelin.latticy.mapper.ActivityMapper;
import io.github.talelin.latticy.model.ActivityDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.ActivityDetailDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-23
 */
@Service
public class ActivityService extends ServiceImpl<ActivityMapper,ActivityDO> {

    public ActivityDO getActive(Long id){
        ActivityDO activityDO = this.getById(id);
        if(null == activityDO){
            throw new NotFoundException();
        }
        return activityDO;
    }

    public void updateActiveById(ActiveDTO dto,Long id){
        ActivityDO active = this.getActive(id);
        BeanUtils.copyProperties(dto,active);
        this.updateById(active);
    }

    public void deleteActive(Long id){
        ActivityDO active = this.getActive(id);
        this.getBaseMapper().deleteById(id);
    }

    public ActivityDetailDO getDetailById(Long id){
        return this.getBaseMapper().getDetail(id);
    }
}
