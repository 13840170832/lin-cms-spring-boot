package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.mapper.SpecKeyMapper;
import io.github.talelin.latticy.model.SpecKeyDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-29
 */
@Service
public class SpecKeyService extends ServiceImpl<SpecKeyMapper,SpecKeyDO> {

    public List<SpecKeyDO> getBySpuId(Long spuId){
        return this.getBaseMapper().getBySpuId(spuId);
    }
}
