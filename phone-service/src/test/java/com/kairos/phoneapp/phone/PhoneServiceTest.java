package com.kairos.phoneapp.phone;

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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneServiceTest {

    @Mock
    PhoneRepository phoneRepository;

    @InjectMocks
    private PhoneService phoneService = new PhoneServiceImpl(phoneRepository, new ModelMapper());

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllOKTest()
    {

        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(1L);
        phoneDTO.setDescripcion("Telefono de prueba");
        phoneDTO.setImagenURL("www.imagen.com");
        phoneDTO.setNombre("Nokia 3330");
        phoneDTO.setPrecio(59.89);

        Phone phone = new Phone();
        phone.setId(1L);
        phone.setDescripcion("Telefono de prueba");
        phone.setImagenURL("www.imagen.com");
        phone.setNombre("Nokia 3330");
        phone.setPrecio(59.89);

        List<Phone> phones = Collections.singletonList(phone);

        Mockito.when(phoneRepository.findAll()).thenReturn(phones);
        List<PhoneDTO> returnedPhones = phoneService.findAll();

        Assert.assertNotNull(returnedPhones);
        Assert.assertEquals(returnedPhones.size(), 1);
        Assert.assertEquals(returnedPhones.get(0), phoneDTO);
    }

}
