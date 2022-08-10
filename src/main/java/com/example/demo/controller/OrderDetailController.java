package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.OrderDetail;
import com.example.demo.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping("/order")
    public ResponseEntity<Optional<OrderDetail>> getOrderDetail(Long id) { return ResponseEntity.ok().body(orderDetailService.getOrderDetail(id)); }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDetail>> getOrderDetailByOrder(Long orderID) { return ResponseEntity.ok().body(orderDetailService.getOrderDetailByOrder(orderID)); }

    @PostMapping("/save/order")
    public ResponseEntity<OrderDetail> saveOrderDetail(OrderDetail orderDetail) { return ResponseEntity.ok().body(orderDetailService.saveOrderDetail(orderDetail));}
}
