package com.kairos.phoneapp.order;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDTO save(OrderDTO orderDto) {
        logger.info("OrderService save order: {}", orderDto.toString());
        Order order = this.convertToEntity(orderDto);
        order = orderRepository.save(order);
        return convertToDto(order);
    }

    private Order convertToEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, Order.class);
    }
    private OrderDTO convertToDto(Order order){
        return modelMapper.map(order, OrderDTO.class);
    }
}
