package com.example.tacocloud.tacos.rest;

import com.example.tacocloud.tacos.data.OrderRepository;
import com.example.tacocloud.tacos.messaging.OrderMessagingService;
import com.example.tacocloud.tacos.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "http://localhost:8080")
public class OrderApiController {

    @Autowired
    private OrderMessagingService messageService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder order) {
        messageService.sendOrder(order);
        return orderRepository.save(order);
    }
}
