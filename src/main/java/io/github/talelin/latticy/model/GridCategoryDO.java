package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("grid_category")
public class GridCategoryDO extends BaseModel{

    private String title;
    private String img;
    private String name;
    private Integer categoryId;
    private Integer rootCategoryId;

}
