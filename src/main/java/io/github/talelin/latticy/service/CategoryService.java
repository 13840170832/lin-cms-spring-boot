package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.CategoryDTO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.model.CategoryDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-29
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, CategoryDO> {

    public CategoryDO getCategoryById(Long id){
        CategoryDO categoryDO = this.getById(id);
        if(null == categoryDO){
            throw new NotFoundException(40000);
        }
        return categoryDO;
    }

    public void updateCategory(CategoryDTO dto,Long id){
        CategoryDO categoryDO = this.getById(id);
        if(null == categoryDO){
            throw new NotFoundException(40000);
        }
        BeanUtils.copyProperties(dto,categoryDO);
        this.updateById(categoryDO);
    }

    public void deleteCategory(Long id){
        CategoryDO categoryDO = this.getById(id);
        if(null == categoryDO){
            throw new NotFoundException(40000);
        }
        this.getBaseMapper().deleteById(id);
    }
}
