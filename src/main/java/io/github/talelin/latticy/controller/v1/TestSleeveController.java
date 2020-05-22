package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.TestSleeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestSleeveController {

    @Autowired
    private TestSleeveService bannerService;

    @Autowired
    private BannerMapper bannerMapper;

    @GetMapping("/test1")
    public List<BannerDO> test1(){
        return bannerService.getAll();
    }

    @GetMapping("/test3")
    public List<BannerDO> test3(){
        return bannerService.getAll1();
    }

    @GetMapping("/test2")
    public long test2(){
        return bannerService.insertBanner();
    }

    @GetMapping("/test4")
    public List<BannerDO> test4(){
        return bannerMapper.selectList(null);
    }


}
