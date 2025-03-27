package com.project.shopapp.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopapp.DTO.OrderDTO;
import com.project.shopapp.Model.Order;
import com.project.shopapp.Repository.OrderRepository;
import com.project.shopapp.Repository.UserRepository;
import com.project.shopapp.Service.Impl.IOderService;

@Service
public class OrderService implements IOderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(long id) throws Exception {
        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy id order này"));
            orderRepository.delete(order);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order getByOrderId(long id) throws Exception {
        try {
            return orderRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy id order này"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) throws Exception {
        try {
            userRepository.findById(orderDTO.getUserId())
                    .orElseThrow(() -> new Exception("userId không tồn tại"));
            Order order = Order.builder()
                    .userId(orderDTO.getUserId())
                    .fullName(orderDTO.getFullName())
                    .email(orderDTO.getEmail())
                    .phoneNumber(orderDTO.getPhoneNumber())
                    .note(orderDTO.getNote())
                    .status(orderDTO.getStatus())
                    .address(orderDTO.getAddress())
                    .orderDate(null)
                    .totalMoney(orderDTO.getTotalMoney())
                    .shippingAddress(null)
                    .shippingMethod(null)
                    .shippingDate(null)
                    .trackingNumber(orderDTO.getTrackingNumber())
                    .paymentMethod(orderDTO.getPaymentMethod())
                    .isActive(false)
                    .build();
            return orderRepository.save(order);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order updateOrder(OrderDTO orderDTO, long id) throws Exception {
        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new Exception("Mã id order này không tìm thấy để sửa"));
            userRepository.findById(orderDTO.getUserId())
                    .orElseThrow(() -> new Exception("userId không tồn tại"));
            order.setUserId(orderDTO.getUserId());
            order.setFullName(orderDTO.getFullName());
            order.setEmail(orderDTO.getEmail());
            order.setPhoneNumber(orderDTO.getPhoneNumber());
            order.setNote(orderDTO.getNote());
            order.setStatus(orderDTO.getStatus());
            order.setAddress(orderDTO.getAddress());
            order.setOrderDate(null);
            order.setTotalMoney(orderDTO.getTotalMoney());
            order.setShippingMethod(orderDTO.getShippingMethod());
            order.setShippingAddress(orderDTO.getShippingAddress());
            order.setShippingDate(null);
            order.setTrackingNumber(orderDTO.getTrackingNumber());
            order.setPaymentMethod(orderDTO.getPaymentMethod());
            order.setActive(false);
            return orderRepository.save(order);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
