package net.spboot.guru.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.spboot.guru.university.model.Address;
import net.spboot.guru.university.service.AddressService;

@RestController
@RequestMapping("/api/v1/address/")
@AllArgsConstructor
@RefreshScope
public class AddressController {
    
    @Autowired
    private  AddressService addressService;
    
    @GetMapping("{personId}/{zipCode}")
    public void  regiterAddress(@PathVariable("personId") String personId, @PathVariable("zipCode") String zipCode) {
       
       addressService.registerAddressByzipCode(personId, zipCode);
    }
    
    @GetMapping("{personId}")
    public Address getAddressBypersonId(@PathVariable("personId") String personId) {
        return addressService.getAddressBypersonId(personId);
    }

}
