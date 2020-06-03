package io.github.talelin.latticy.model;

import java.math.BigDecimal;
import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("coupon_template")
public class CouponTemplateDO extends BaseModel {


    private String title;

    private String description;

    private BigDecimal fullMoney;

    private BigDecimal minus;

    /**
     * 国内多是打折，国外多是百分比 off
     */
    private BigDecimal discount;

    /**
     * 1. 满减券 2.折扣券 3.无门槛券 4.满金额折扣券
     */
    private Integer type;


}
