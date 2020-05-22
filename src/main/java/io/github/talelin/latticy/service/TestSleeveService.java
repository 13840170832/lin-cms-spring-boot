package io.github.talelin.latticy.service;

import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSleeveService {

    @Autowired
    private BannerMapper bannerMapper;

    public List<BannerDO> getAll(){
        return bannerMapper.getAllBanners();
    }

    public List<BannerDO> getAll1(){
        return bannerMapper.getAllBanners1();
    }

    public long insertBanner(){
        BannerDO bannerDO = new BannerDO();
        bannerDO.setName("NewBanner");
        bannerDO.setTitle("NewBannerTitle");

        bannerMapper.insertBanner(bannerDO);
        return bannerDO.getId();
    }
}
