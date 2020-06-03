package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.SkuDTO;
import io.github.talelin.latticy.mapper.SkuMapper;
import io.github.talelin.latticy.model.SkuDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.SkuDetailDO;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-27
 */
@Service
public class SkuService extends ServiceImpl<SkuMapper,SkuDO> {

    public SkuDO getSkuById(Integer id){
        SkuDO skuDO = this.getById(id);
        if(null == skuDO){
            throw new NotFoundException(60000);
        }
        return skuDO;
    }

    public void updateSku(SkuDTO dto,Long id){
        SkuDO skuDO = this.getSkuById(id.intValue());
        BeanUtils.copyProperties(dto,skuDO);
        this.updateById(skuDO);
    }

    public void deleteSku(Long id){
        SkuDO skuDO = this.getSkuById(id.intValue());
        this.getBaseMapper().deleteById(id);
    }

    public SkuDetailDO getSkuDetail(Long id){
        SkuDetailDO sku = this.getBaseMapper().getDetail(id);
        if(null == sku){
            throw new NotFoundException(60000);
        }
        return sku;
    }

}
