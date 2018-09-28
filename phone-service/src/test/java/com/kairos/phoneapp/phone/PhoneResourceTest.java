package com.kairos.phoneapp.phone;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PhoneResource.class, secure = false)
public class PhoneResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneService phoneService;

    @Test
    public void getAllOKTest() throws Exception {
        PhoneDTO phone = new PhoneDTO();
        phone.setId(1L);
        phone.setDescripcion("Telefono de prueba");
        phone.setImagenURL("www.imagen.com");
        phone.setNombre("Nokia 3330");
        phone.setPrecio(59.89);

        when(phoneService.findAll()).thenReturn(Collections.singletonList(phone));

        mockMvc.perform(get("/phones").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(1))).
                andExpect(jsonPath("$[0].id").value(1L)).
                andExpect(jsonPath("$[0].nombre").value("Nokia 3330")).
                andExpect(jsonPath("$[0].imagenURL").value("www.imagen.com")).
                andExpect(jsonPath("$[0].descripcion").value("Telefono de prueba")).
                andExpect(jsonPath("$[0].precio").value(59.89));
    }

}
