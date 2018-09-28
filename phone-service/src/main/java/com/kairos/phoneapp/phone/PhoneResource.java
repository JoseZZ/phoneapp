package com.kairos.phoneapp.phone;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    final Logger logger = LoggerFactory.getLogger(PhoneResource.class);

    private PhoneService phoneService;

    @Autowired
    public PhoneResource(PhoneService phoneService){
        this.phoneService = phoneService;
    }

    @GetMapping("/phones")
    public List<PhoneDTO> getPhones(){
        logger.info("GET /users");
        return phoneService.findAll();
    }
}
