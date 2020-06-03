package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class SpecValueDTO {

    @NotBlank
    @Length(min=1,max=30)
    private String value;

    @Positive
    private Integer specId;

    private String extend;
}
