package net.spboot.guru.university.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.spboot.guru.university.request.Address;

@FeignClient(name="address-service" /*, url="localhost:8281/api/address"*/)
public interface AddressFeignClientService {
    
    @GetMapping("/api/address/{personId}/{zipCode}")
    public Address registerAddress(@PathVariable("personId") String personId, @PathVariable("zipCode") String zipCode);
    
    @GetMapping("/api/address/{personId}")
    public Address getAddressBypersonId(@PathVariable("personId") String personI);

}
