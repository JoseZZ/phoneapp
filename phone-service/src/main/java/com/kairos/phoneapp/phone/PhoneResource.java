package com.kairos.phoneapp.phone;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@RestController
public class PhoneResource {

    private PhoneService phoneService;

    @Autowired
    public PhoneResource(PhoneService phoneService){
        this.phoneService = phoneService;
    }

    @GetMapping("/phones")
    public Collection<PhoneDTO> getPhones(){
        List<PhoneDTO> telefonos = new ArrayList<>();
        PhoneDTO telefono = new PhoneDTO("http://imagen.com", "Nokia 3310", "Nokia antiguo", new Double(34.98));
        telefonos.add(telefono);
        return telefonos;
    }
}
