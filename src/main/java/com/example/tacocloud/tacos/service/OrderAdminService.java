package com.example.tacocloud.tacos.service;

import com.example.tacocloud.tacos.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author marat
 */
@Service
@Slf4j
public class OrderAdminService {

    @Autowired
    private OrderRepository orderRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {

        orderRepository.deleteAll();
        log.info("Все заказы удалены");
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteOrderById(String orderId) {

        orderRepository.deleteById(new ObjectId(orderId));
    }
}
