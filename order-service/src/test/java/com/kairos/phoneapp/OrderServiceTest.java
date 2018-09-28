package com.kairos.phoneapp;

import com.kairos.phoneapp.order.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService = new OrderServiceImpl(orderRepository, new ModelMapper());

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createBusinessTermOKTest()
    {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1L);
        orderDTO.setNombre("Juan");
        orderDTO.setApellidos("Gomez Perez");
        orderDTO.setEmail("juan@gmail.com");
        orderDTO.setTelefonos(Collections.singletonList(1L));
        orderDTO.setTotal(45.76);

        Order order = new Order();
        order.setId(1L);
        order.setNombre("Juan");
        order.setApellidos("Gomez Perez");
        order.setEmail("juan@gmail.com");
        order.setItems(Collections.emptyList());
        order.setTotal(45.76);

        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);
        orderDTO = orderService.save(orderDTO);

        Assert.assertNotNull(orderDTO);
        Assert.assertEquals(orderDTO.toString(), order.toString());
    }

}
