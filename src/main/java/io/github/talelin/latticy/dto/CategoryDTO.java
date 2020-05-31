package io.github.talelin.latticy.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CategoryDTO {

    @NotNull
    @Length(min=1,max=20)
    private String name;

    @Positive
    private Integer index;

    @Min(0)
    @Max(1)
    private Integer online;

    private String img;

    private String description;


    private Integer isRoot;

    private Integer parentId;

}
