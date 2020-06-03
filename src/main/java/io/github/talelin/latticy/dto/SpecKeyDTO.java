package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SpecKeyDTO {

    @NotBlank
    @Length(min=1,max=20)
    private String name;

    private String unit;

    @Min(0)
    @Max(1)
    private Integer standard;

    private String description;
}
