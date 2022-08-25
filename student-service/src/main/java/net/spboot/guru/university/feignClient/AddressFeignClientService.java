package net.spboot.guru.university.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.spboot.guru.university.request.Address;

@FeignClient(name="ADDRESS-SERVICE" /*, url="localhost:8283/api/v1/address"*/)
public interface AddressFeignClientService {
    
    @GetMapping("/api/v1/address/{personId}/{zipCode}")
    public Address registerAddress(@PathVariable("personId") String personId, @PathVariable("zipCode") String zipCode);
    
    @GetMapping("/api/v1/address/{personId}/")
    public Address getAddressBypersonId(@PathVariable("personId") String personI);

}
