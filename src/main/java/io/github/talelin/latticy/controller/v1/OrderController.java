package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.OrderDTO;
import io.github.talelin.latticy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.OrderDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-06-02
*/
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated OrderDTO dto,
            @PathVariable @Positive Long id) {
        this.orderService.updateOrder(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        orderService.deleteOrder(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public OrderDO get(@PathVariable @Positive Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/page")
    public PageResponseVO<OrderDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page,
            @RequestParam(required = false) String searchStr
    ) {
        Page<OrderDO> pager = new Page<>(page,count);
        IPage<OrderDO> paging = orderService.lambdaQuery()
                .like(null!=searchStr,OrderDO::getOrderNo,searchStr)
                .page(pager);
        return new PageResponseVO(paging.getTotal(),paging.getRecords(),paging.getCurrent(),paging.getSize());
    }

}
