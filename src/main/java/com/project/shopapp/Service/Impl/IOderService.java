package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.OrderDTO;
import com.project.shopapp.Model.Order;

public interface IOderService {
    List<Order> getAllOrder();

    void deleteOrder(long id) throws Exception;

    Order getByOrderId(long id) throws Exception;

    Order createOrder(OrderDTO orderDTO) throws Exception;

    Order updateOrder(OrderDTO orderDTO, long id) throws Exception;

}
