package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.OrderDetailDTO;
import com.project.shopapp.Model.OrderDetail;

public interface IOderDetailService {
    List<OrderDetail> getAllOrderDetails();

    void deleteOrderDetail(long id) throws Exception;

    OrderDetail getByOrderDetailId(long id) throws Exception;

    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws Exception;

    OrderDetail updateOrderDetail(OrderDetailDTO orderDetailDTO, long id) throws Exception;

}
