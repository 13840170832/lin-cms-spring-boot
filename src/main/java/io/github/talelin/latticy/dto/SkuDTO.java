package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
public class SkuDTO {

    private BigDecimal price;

    private BigDecimal discountPrice;

    @Min(0)
    @Max(1)
    private Integer online;

    private String img;

    @NotBlank
    @Length(min=1,max=30)
    private String title;

    private Integer spuId;

    private String specs;

    private String code;

    @NotNull
    private Integer stock;

    @Positive
    private Integer categoryId;

    @Positive
    private Integer rootCategoryId;

}
