package io.github.talelin.latticy.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActivityDetailDO extends ActivityDO {

    private List<CouponDO> couponList;

}
