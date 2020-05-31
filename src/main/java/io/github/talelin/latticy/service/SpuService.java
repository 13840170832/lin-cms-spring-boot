package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.model.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-27
 */
@Service
public class SpuService extends ServiceImpl<SpuMapper,SpuDO> {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuService skuService;

    @Autowired
    private SpecKeyService specKeyService;

    @Autowired
    private SpuKeyService spuKeyService;

    @Autowired
    private SpuImgService spuImgService;

    @Autowired
    private SpuDetailImgService spuDetailImgService;

    public SpuDetailDO  getDetail(Long id){
        return this.getBaseMapper().getDetail(id);
    }

    public void create(SpuDTO dto){
        SpuDO spuDO = new SpuDO();
        BeanUtils.copyProperties(dto,spuDO);
        CategoryDO categoryDO = categoryService.getById(dto.getCategoryId());
        spuDO.setRootCategoryId(categoryDO.getParentId());
        skuService.getSkuById(dto.getDefaultSkuId());
        specKeyService.getSpecKeyById(dto.getSketchSpecId());
        this.save(spuDO);

        if(dto.getSpecKeyIdList() != null){
            this.insertSpecKeyIdList(dto.getSpecKeyIdList(),spuDO.getId());
        }

        List<String> spuImgList = new ArrayList<>();
        if(null == dto.getSpuImgList()){
            spuImgList.add(dto.getImg());
        }else{
            spuImgList = dto.getSpuImgList();
        }
        this.insertSpuImgList(spuImgList,spuDO.getId());

        if(dto.getSpuDetailImgList() != null){
            this.insertSpuDetailIMgList(dto.getSpuDetailImgList(),spuDO.getId());
        }

    }

    private void insertSpuImgList(List<String> spuImgList,Long spuId){
        List<SpuImgDO> spuImgDOList = spuImgList.stream().map(s->{
            SpuImgDO spuImgDO = new SpuImgDO();
            spuImgDO.setImg(s);
            spuImgDO.setSpuId(spuId.intValue());
            return spuImgDO;
        }).collect(Collectors.toList());
        spuImgService.saveBatch(spuImgDOList);
    }

    private void insertSpuDetailIMgList(List<String> spuDetailImgList,Long spuId){
        List<SpuDetailImgDO> spuDetailImgDOList = new ArrayList<>();
        for(int i=0;i<spuDetailImgList.size();i++){
            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
            spuDetailImgDO.setImg(spuDetailImgList.get(i))
                    .setSpuId(spuId.intValue())
                    .setIndex(i);
            spuDetailImgDOList.add(spuDetailImgDO);
        }
        spuDetailImgService.saveBatch(spuDetailImgDOList);
    }

    private void insertSpecKeyIdList(List<Integer> specKeyIdList,Long spuId){
        List<SpuKeyDO> spuKeyDOList = specKeyIdList.stream().map(sk->{
            SpuKeyDO spuKeyDO = new SpuKeyDO();
            spuKeyDO.setSpecKeyId(sk)
                    .setSpuId(spuId.intValue());
            return spuKeyDO;
        }).collect(Collectors.toList());
        spuKeyService.saveBatch(spuKeyDOList);
    }
}
