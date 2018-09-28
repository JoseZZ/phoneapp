package com.kairos.phoneapp.order;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Getter
@Setter
@RestController
public class OrderResource {

    private final Logger logger = LoggerFactory.getLogger(OrderResource.class);

    private OrderService orderService;

    @Autowired
    PhoneServiceProxy phoneServiceProxy;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<Object> createOrder(@Valid @RequestBody OrderDTO order){
        logger.info("POST /orders with request: {}", order.toString());
        List<ItemDTO> items = phoneServiceProxy.getPhones();
        // Validar telefonos
        OrderDTO orderCreated = orderService.save(order);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orderCreated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
