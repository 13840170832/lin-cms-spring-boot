package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.OrderDTO;
import io.github.talelin.latticy.mapper.OrderMapper;
import io.github.talelin.latticy.model.OrderDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeanUtils;
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
public class OrderService extends ServiceImpl<OrderMapper,OrderDO> {

    public OrderDO getOrder(Long id){
        OrderDO order = this.getById(id);
        if(null == order){
            throw new NotFoundException();
        }
        return order;
    }

    public void updateOrder(OrderDTO dto, Long id){
        OrderDO order = this.getOrder(id);
        BeanUtils.copyProperties(dto,order);
        this.updateById(order);
    }

    public void deleteOrder(Long id){
        OrderDO order = this.getOrder(id);
        this.getBaseMapper().deleteById(id);
    }
}
