package com.kairos.phoneapp.order;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="phone-service", url="localhost:8081")
public interface PhoneServiceProxy {
    @GetMapping("/phones")
    List<ItemDTO> getPhones();
}
