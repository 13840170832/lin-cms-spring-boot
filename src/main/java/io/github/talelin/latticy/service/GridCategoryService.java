package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.GridCategoryDTO;
import io.github.talelin.latticy.mapper.GridCategoryMapper;
import io.github.talelin.latticy.model.GridCategoryDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GridCategoryService extends ServiceImpl<GridCategoryMapper, GridCategoryDO> {

    public GridCategoryDO getGridById(Long id){
        GridCategoryDO grid = this.getById(id);
        if(null == grid){
            throw new NotFoundException(30000);
        }
        return grid;
    }

    public void updateGrid(GridCategoryDTO dto,Long id){
        GridCategoryDO grid = this.getGridById(id);
        BeanUtils.copyProperties(dto,grid);
        grid.setUpdateTime(new Date());
        this.updateById(grid);
    }

    public void deleteGrid(Long id){
        GridCategoryDO grid = this.getGridById(id);
        if(null == grid){
            throw new NotFoundException(30000);
        }
        this.getBaseMapper().deleteById(id);
    }


}
