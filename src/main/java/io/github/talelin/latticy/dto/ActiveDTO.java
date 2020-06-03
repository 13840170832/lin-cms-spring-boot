package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActiveDTO {

    @NotBlank
    @Length(min=1,max=20)
    private String title;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String remark;

    private Integer online;

    @NotBlank
    @Length(min=2,max=256)
    private String entranceImg;

    private String internalTopImg;

    @NotBlank
    @Length(min=1,max=20)
    private String name;

}
