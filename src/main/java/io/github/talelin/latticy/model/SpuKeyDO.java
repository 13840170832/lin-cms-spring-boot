package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-05-30
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("spu_key")
public class SpuKeyDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer spuId;

    private Integer specKeyId;


}
