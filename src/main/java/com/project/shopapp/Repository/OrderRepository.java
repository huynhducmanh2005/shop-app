package com.project.shopapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.Model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
