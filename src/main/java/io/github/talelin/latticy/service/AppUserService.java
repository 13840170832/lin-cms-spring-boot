package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.mapper.AppUserMapper;
import io.github.talelin.latticy.model.AppUserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-06-02
 */
@Service
public class AppUserService extends ServiceImpl<AppUserMapper,AppUserDO> {

    public AppUserDO getAppUser(Long id){
        AppUserDO user = this.getById(id);
        if(null == user){
            throw new NotFoundException();
        }
        return user;
    }

    public void deleteUser(Long id){
        AppUserDO user = this.getAppUser(id);
        this.getBaseMapper().deleteById(id);
    }
}
