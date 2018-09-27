package com.kairos.phoneapp.phone;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface PhoneService {

    public Collection<PhoneDTO> findAll();
}
