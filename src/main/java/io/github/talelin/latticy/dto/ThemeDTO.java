package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ThemeDTO {

    @NotNull
    @Length(min=1,max=20)
    private String title;

    @Length(min=2,max=256)
    private String description;

    @NotNull
    @Length(min=2,max=20)
    private String name;

    private String tplName;

    @Length(min=2,max=256)
    private String entranceImg;

    private String extend;

    @Length(min=2,max=256)
    private String internalTopImg;

    @Length(min=2,max=256)
    private String titleImg;

    @Min(0)
    @Max(1)
    private Integer online;
}
