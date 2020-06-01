package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GridCategoryDTO {

    @NotNull
    @Length(min=1,max=10)
    private String title;
    @NotNull
    @Length(min=2,max=256)
    private String img;
    private String name;
    private Integer categoryId;
    private Integer rootCategoryId;

}
