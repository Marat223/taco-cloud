package com.example.tacocloud.tacos.web;

import com.example.tacocloud.tacos.data.OrderRepository;
import com.example.tacocloud.tacos.data.TacoRepository;
import com.example.tacocloud.tacos.model.Taco;
import com.example.tacocloud.tacos.model.TacoOrder;
import com.example.tacocloud.tacos.rest.InternalRestClient;
import com.example.tacocloud.tacos.service.OrderAdminService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
public class TacoController {

    @Autowired
    private TacoRepository tacoRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderAdminService orderAdminService;

    @GetMapping(params = "recent")
    public Iterable<Taco> RecentTacos() {

        return tacoRepository.findAll(PageRequest.of(0, 12, Sort.by("createdAt").descending())).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") String id) {

        Optional<Taco> taco = tacoRepository.findById(new ObjectId(id));
        if (taco.isPresent()) {
            return new ResponseEntity<>(taco.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {

        return tacoRepository.save(taco);
    }

    @PutMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TacoOrder putOrder(@PathVariable("orderId") String orderId, @RequestBody TacoOrder order) {

        order.setId(new ObjectId(orderId));

        return orderRepository.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TacoOrder patchOrder(@PathVariable("orderId") String orderId, @RequestBody TacoOrder patch) {

        TacoOrder order = orderRepository.findById(new ObjectId(orderId)).get();
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }

        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") String orderId) {

        try {
            orderAdminService.deleteOrderById(orderId);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
