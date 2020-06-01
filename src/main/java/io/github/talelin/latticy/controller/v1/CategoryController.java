package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.autoconfigure.exception.ParameterException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.CategoryDTO;
import io.github.talelin.latticy.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-05-29
*/
@RestController
@RequestMapping("/v1/category")
@Api(tags = "分类管理")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    @ApiOperation(value="创建分类")
    public CreatedVO create(@RequestBody @Validated CategoryDTO dto) {
        CategoryDO categoryDO = new CategoryDO();
        BeanUtils.copyProperties(dto,categoryDO);
        this.categoryService.save(categoryDO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    @ApiOperation(value="更新分类")
    public UpdatedVO update(@RequestBody @Validated CategoryDTO dto,
                            @PathVariable @Positive Long id) {
        this.categoryService.updateCategory(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="删除分类")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        this.categoryService.deleteCategory(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="查询分类详情")
    public CategoryDO get(@PathVariable @Positive Long id) {
        return this.categoryService.getCategoryById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value="查询分类列表")
    public PageResponseVO<CategoryDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page,
            @RequestParam Integer isRoot,
            @RequestParam(required = false) Integer parentId
    ) {
        QueryWrapper<CategoryDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(CategoryDO::getIsRoot,isRoot)
                .orderByAsc(CategoryDO::getIndex);
        if(0 == isRoot){
            if(null == parentId){
                throw new ParameterException(40001);
            }else{
                wrapper.lambda().eq(CategoryDO::getParentId,parentId);
            }
        }
        Page<CategoryDO> pager = new Page<>(page,count);
        IPage<CategoryDO> paging = this.categoryService.getBaseMapper().selectPage(pager,wrapper);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

}
