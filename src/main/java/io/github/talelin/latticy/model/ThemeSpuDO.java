package io.github.talelin.latticy.model;

import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("theme_spu")
public class ThemeSpuDO{


    private Integer themeId;

    private Integer spuId;


}