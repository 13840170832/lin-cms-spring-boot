package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@TableName("banner_item")
public class BannerItemDO extends BaseModel{
    @TableId(value="id", type= IdType.AUTO)
    private Long id;
    private String img;
    private String keyword;
    private Integer type;
    private Integer bannerId;
    private String name;

}
