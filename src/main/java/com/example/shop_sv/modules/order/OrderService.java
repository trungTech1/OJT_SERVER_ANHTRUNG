package com.example.shop_sv.modules.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    public OrderModel changeOrderStatus(Byte id, OrderModel orderModel) {
        OrderModel order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return null;
        }
        order.setStatus(orderModel.getStatus());
        return orderRepository.save(order);
    }
}
