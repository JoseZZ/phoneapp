package com.kairos.phoneapp;

import com.kairos.phoneapp.order.OrderDTO;
import com.kairos.phoneapp.order.OrderResource;
import com.kairos.phoneapp.order.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;
import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderResource.class, secure = false)
public class OrderResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void createOrderOK() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1L);
        orderDTO.setNombre("Juan");
        orderDTO.setApellidos("Gomez Perez");
        orderDTO.setEmail("juan@gmail.com");
        orderDTO.setTelefonos(Collections.singletonList(1L));
        orderDTO.setTotal(45.76);

        Gson gson = new Gson();

        when(orderService.save(any(OrderDTO.class))).thenReturn(orderDTO);

        mockMvc.perform(post("/orders").
                contentType(MediaType.APPLICATION_JSON).
                content(gson.toJson(orderDTO)).
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isCreated());
    }
    
}
