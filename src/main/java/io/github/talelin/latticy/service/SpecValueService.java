package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.SpecValueDTO;
import io.github.talelin.latticy.mapper.SpecValueMapper;
import io.github.talelin.latticy.model.SpecValueDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeanUtils;
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
public class SpecValueService extends ServiceImpl<SpecValueMapper,SpecValueDO> {

    public SpecValueDO getSpecValue(Long id){
        SpecValueDO specValue = this.getById(id);
        if(null ==specValue){
            throw new NotFoundException(70001);
        }
        return specValue;
    }

    public void updateSpecValue(SpecValueDTO dto,Long id){
        SpecValueDO value = this.getSpecValue(id);
        BeanUtils.copyProperties(dto,value);
        this.updateById(value);
    }

    public void deleteSpecValue(Long id){
        SpecValueDO value = this.getSpecValue(id);
        this.getBaseMapper().deleteById(id);
    }

}
