package io.github.talelin.latticy.model;

import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("app_user")
public class AppUserDO extends BaseModel {


    private String openid;

    private String nickname;

    private Integer unifyUid;

    private String email;

    private String password;

    private String mobile;

    private String wxProfile;


}
