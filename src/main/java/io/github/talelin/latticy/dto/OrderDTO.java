package io.github.talelin.latticy.dto;

import io.github.talelin.latticy.model.OrderDO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDTO {

    @NotBlank
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
