package io.github.talelin.latticy.model;

import lombok.Data;

import java.util.List;

@Data
public class SpuDetailDO extends SpuDO{

    private String categoryName;
    /**可视规格名*/
    private String sketchSpecKeyName;

    private String defaultSkuTitle;

    private List<String> spuImgList;

    private List<String> spuDetailImgList;

}
