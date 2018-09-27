package com.kairos.phoneapp.phone;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService{

    private final static Logger LOG = LoggerFactory.getLogger(PhoneServiceImpl.class);

    private PhoneRepository phoneRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository, ModelMapper modelMapper) {
        this.phoneRepository = phoneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PhoneDTO> findAll() {
        LOG.debug("Obtenemos todos los telefonos");
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream().map(phone -> convertToDto(phone)).collect(Collectors.toList());
    }

    private PhoneDTO convertToDto(Phone phone){
        return modelMapper.map(phone, PhoneDTO.class);
    }
}
