package com.project.shopapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopapp.DTO.OrderDetailDTO;
import com.project.shopapp.Model.OrderDetail;
import com.project.shopapp.Response.OrderDetailResponse;
import com.project.shopapp.Service.Services.OrderDetailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/order-details")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/")
    public ResponseEntity<?> getAllOrderDetails() {
        List<OrderDetail> listOrderDetail = orderDetailService.getAllOrderDetails();
        return ResponseEntity.ok(listOrderDetail.stream().map(OrderDetailResponse::fromOrderDetail).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByOrderDetailId(@PathVariable long id) {
        try {
            OrderDetail orderDetail = orderDetailService.getByOrderDetailId(id);
            return ResponseEntity.ok(OrderDetailResponse.fromOrderDetail(orderDetail));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetailDTO) {
        try {
            OrderDetail orderDetail = orderDetailService.createOrderDetail(orderDetailDTO);
            return ResponseEntity.ok(orderDetail);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@Valid @PathVariable long id,
            @RequestBody OrderDetailDTO orderDetailDTO) {
        try {
            OrderDetail orderDetail = orderDetailService.updateOrderDetail(orderDetailDTO, id);
            return ResponseEntity.ok(orderDetail);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable long id) {
        try {
            orderDetailService.deleteOrderDetail(id);
            return ResponseEntity.ok(String.format("Đã xóa thành công id = %d của oderdetail này", id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
