package com.kairos.phoneapp.phone;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public interface PhoneService {

    List<PhoneDTO> findAll();
}
