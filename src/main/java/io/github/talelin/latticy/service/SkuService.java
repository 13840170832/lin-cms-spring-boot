package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.mapper.SkuMapper;
import io.github.talelin.latticy.model.SkuDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
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

}
