package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BannerService extends ServiceImpl<BannerMapper, BannerDO> {

    @Autowired
    private BannerItemMapper bannerItemMapper;

    public void update(BannerDTO dto,Long id){
        BannerDO bannerDO = this.getById(id);
        if(null == bannerDO){
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(dto,bannerDO);
        this.updateById(bannerDO);
    }

    @Transactional
    public void delete(Long id){
        BannerDO bannerDO = this.getById(id);
        if(null==bannerDO){
            throw new NotFoundException(20000);
        }
        this.getBaseMapper().deleteById(id);

        QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BannerItemDO::getBannerId,id);
        List<BannerItemDO> items = bannerItemMapper.selectList(wrapper);
        List<Long> ids = items
                .stream()
                .map(BannerItemDO::getId)
                .collect(Collectors.toList());
        this.bannerItemMapper.deleteBatchIds(ids);
    }

    public BannerWithItemsBO getBannerWithItems(Long id){
        BannerDO bannerDO = this.getById(id);
        if(null==bannerDO){
            throw new NotFoundException(20000);
        }
        QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();
//        wrapper.eq("banner_id",id);
//        wrapper.lambda().eq(bannerItemDO -> bannerItemDO.getBannerId(),id);
        wrapper.lambda().eq(BannerItemDO::getBannerId,id);
        List<BannerItemDO> items = bannerItemMapper.selectList(wrapper);
        return new BannerWithItemsBO(bannerDO,items);
    }
}
