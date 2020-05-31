package io.github.talelin.latticy.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class BannerItemDTO {
    @NotBlank
    @Length(min=4,max=256)
    private String img;
    @NotBlank
    @Length(min=2,max=20)
    private String keyword;
    private Integer type;
    @NotNull
    @Positive
    private Integer bannerId;
    @NotBlank
    @Length(min=2,max=20)
    private String name;
}
