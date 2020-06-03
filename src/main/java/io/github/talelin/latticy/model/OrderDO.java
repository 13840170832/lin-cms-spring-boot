package io.github.talelin.latticy.model;

import java.math.BigDecimal;
import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("`order`")
public class OrderDO extends BaseModel {


    private String orderNo;

    /**
     * user表外键
     */
    private Integer userId;

    private BigDecimal totalPrice;

    private Integer totalCount;

    private String snapImg;

    private String snapTitle;

    private String snapItems;

    private String snapAddress;

    private String prepayId;

    private BigDecimal finalTotalPrice;

    private Integer status;

    private LocalDateTime placedTime;

    private LocalDateTime expiredTime;


}
