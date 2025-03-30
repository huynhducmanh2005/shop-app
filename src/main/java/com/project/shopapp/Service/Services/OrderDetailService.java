package com.project.shopapp.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopapp.DTO.OrderDetailDTO;
import com.project.shopapp.Model.OrderDetail;
import com.project.shopapp.Repository.OrderDetailRepository;
import com.project.shopapp.Repository.OrderRepository;
import com.project.shopapp.Repository.ProductRepository;
import com.project.shopapp.Service.Impl.IOderDetailService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Service
public class OrderDetailService implements IOderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteOrderDetail(long id) throws Exception {
        try {
            OrderDetail orderDetail = orderDetailRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy id bảng hóa đơn chi tiết này để xóa"));
            orderDetailRepository.delete(orderDetail);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderDetail getByOrderDetailId(long id) throws Exception {
        try {
            return orderDetailRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy id bảng hóa đơn chi tiết này để lấy"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws Exception {
        try {
            OrderDetail orderDetail = OrderDetail.builder()
                    .order(orderRepository.findById(orderDetailDTO.getOrderId())
                            .orElseThrow(() -> new Exception("order id nay khong ton tai")))

                    .product(productRepository.findById(orderDetailDTO.getProductId())
                            .orElseThrow(() -> new Exception("product id nay khong ton tai")))
                    .price(orderDetailDTO.getPrice())
                    .numberOfProduct(orderDetailDTO.getNumberOfProduct())
                    .totalMoney(orderDetailDTO.getNumberOfProduct())
                    .colour(orderDetailDTO.getColour())
                    .build();
            return orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetailDTO orderDetailDTO, long id) throws Exception {
        try {
            OrderDetail orderDetail = orderDetailRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy id orderDetail này để sửa"));
            orderDetail.setOrder(orderRepository.findById(orderDetailDTO.getOrderId())
                    .orElseThrow(() -> new Exception("order id nay khong ton tai")));
            orderDetail.setColour(orderDetailDTO.getColour());
            orderDetail.setNumberOfProduct(orderDetailDTO.getNumberOfProduct());
            orderDetail.setTotalMoney(orderDetailDTO.getTotalMoney());
            orderDetail.setPrice(orderDetailDTO.getPrice());
            orderDetail.setProduct(productRepository.findById(orderDetailDTO.getProductId())
                    .orElseThrow(() -> new Exception("product id nay khong ton tai")));
            return orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
