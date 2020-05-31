package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.BannerItemDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerItemDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-31
 */
@Service
public class BannerItemService extends ServiceImpl<BannerItemMapper,BannerItemDO> {

    public void update(BannerItemDTO dto,Long id){
        BannerItemDO bannerItem = this.getById(id);
        if(null == bannerItem){
            throw new NotFoundException(20001);
        }
        BeanUtils.copyProperties(dto,bannerItem);
        this.updateById(bannerItem);
    }

    public void delete(Long id){
        BannerItemDO bannerItemDO = this.getById(id);
        if(null == bannerItemDO){
            throw new NotFoundException(20001);
        }
        this.getBaseMapper().deleteById(id);
    }
}
