package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.ActiveDTO;
import io.github.talelin.latticy.model.ActivityDetailDO;
import io.github.talelin.latticy.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.ActivityDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-05-23
*/
@RestController
@RequestMapping("/v1/activity")
@Validated
@Api(tags="活动管理")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("")
    public CreatedVO create(@RequestBody @Validated ActiveDTO dto) {
        ActivityDO activityDO = new ActivityDO();
        BeanUtils.copyProperties(dto,activityDO);
        activityService.save(activityDO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated ActiveDTO dto,
            @PathVariable @Positive Long id) {
        activityService.updateActiveById(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        activityService.deleteActive(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public ActivityDO get(@PathVariable @Positive Long id) {
        return activityService.getActive(id);
    }

    @GetMapping("/{id}/detail")
    public ActivityDetailDO getDetail(@PathVariable @Positive Long id){
        return activityService.getDetailById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value = "查询活动列表")
    public PageResponseVO<ActivityDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        Page<ActivityDO> pager = new Page<>(page,count);
        IPage<ActivityDO> paging = this.activityService.page(pager);
        return new PageResponseVO<>(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

}
