package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.GridCategoryDTO;
import io.github.talelin.latticy.model.GridCategoryDO;
import io.github.talelin.latticy.service.GridCategoryService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("v1/grid-category")
@Api(tags="六宫格管理")
@Validated
public class GrigCategoryController {

    @Autowired
    private GridCategoryService gridCategoryService;

    @PostMapping
    @ApiOperation(value="创建六宫格")
    public CreatedVO create(@RequestBody @Validated GridCategoryDTO dto){
        GridCategoryDO gridCategoryDO = new GridCategoryDO();
        BeanUtils.copyProperties(dto,gridCategoryDO);
        this.gridCategoryService.save(gridCategoryDO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    @ApiOperation(value="更新六宫格")
    public UpdatedVO update(@RequestBody @Validated GridCategoryDTO dto,
                            @PathVariable @Positive Long id){
        this.gridCategoryService.updateGrid(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="删除六宫格")
    public DeletedVO delete(@PathVariable @Positive Long id){
        gridCategoryService.deleteGrid(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="查询分类六宫格")
    public GridCategoryDO get(@PathVariable @Positive Long id){
        return gridCategoryService.getGridById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value="查询六宫格列表")
    public PageResponseVO<GridCategoryDO> page(@RequestParam(name="count",required = false,defaultValue = "10")
                                               @Min(value=1,message = "{page.count.min}")
                                               @Max(value=30,message= "{page.count.max}") Long count,
                                               @RequestParam(name="page",required = false,defaultValue = "0")
                                               @Min(value=0,message = "{page.number.min}") Long page){

        Page<GridCategoryDO> pager = new Page<>();
        IPage<GridCategoryDO> paging = gridCategoryService.getBaseMapper().selectPage(pager,null);
        return new PageResponseVO(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }




}
