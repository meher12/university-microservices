package net.spboot.guru.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.spboot.guru.university.model.Address;
import net.spboot.guru.university.service.AddressService;

@RestController
@RequestMapping("api/v1/address/")
@AllArgsConstructor
@Slf4j
public class AddressController {
    
    @Autowired
    private  AddressService addressService;
    
    @GetMapping("{personId}/{zipCode}")
    public void  regiterAddress(@PathVariable("personId") String personId, @PathVariable("zipCode") String zipCode) {
        log.info("New **************************************");
       addressService.registerAddressByzipCode(personId, zipCode);
       log.info("hhhhhhhh **************************************");
       
    }

}
