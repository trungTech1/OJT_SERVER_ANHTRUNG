package com.example.shop_sv.modules.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    // find all orders
    @GetMapping("findAll")
    public List<OrderModel> getAllOrder() {
        return orderService.findAll();
    }

   @PutMapping("changeOrderStatus/{id}")
public ResponseEntity<String> changeOrderStatus(@PathVariable Byte id, @RequestBody OrderModel orderModel) {
    OrderModel order = orderService.changeOrderStatus(id, orderModel);
    if (order != null) {
        return new ResponseEntity<>("Thay đổi trạng thái thành công", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Không thể thay đổi trạng thái", HttpStatus.BAD_REQUEST);
    }
}
}
