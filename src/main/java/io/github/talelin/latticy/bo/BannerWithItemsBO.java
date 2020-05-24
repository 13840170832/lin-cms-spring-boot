package io.github.talelin.latticy.bo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BannerWithItemsBO {

    private int id;

    private String name;

    private String description;
    @JsonIgnore
    private Timestamp createTime;
    @JsonIgnore
    private Timestamp updateTime;
    @JsonIgnore
    @TableLogic
    private Timestamp deleteTime;

    private String title;

    private String img;

    private List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO, List<BannerItemDO> items) {
        BeanUtils.copyProperties(bannerDO,this);
        this.items = items;
    }
}
