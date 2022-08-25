package net.spboot.guru.university.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.spboot.guru.university.request.Address;

@FeignClient(name="address-service", url="http://localhost:8281/api/v1/address")
public interface AddressFeignClientService {
    
    @GetMapping("/{personId}/{zipCode}")
    public Address registerAddress(@PathVariable("personId") String personId, @PathVariable("zipCode") String zipCode);
    
    @GetMapping("/{personId}/")
    public Address getAddressBypersonId(@PathVariable("personId") String personI);

}
