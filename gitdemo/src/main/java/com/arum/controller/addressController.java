package com.arum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arum.entities.Address;
import com.arum.service.*;

@RestController
public class addressController {
	@Autowired
	AddressService addressService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/addresses")
	public List<Address> getAddress(){
		return addressService.getAddress();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addresses")
	public Address createAddress(@RequestBody Address payload) {
		return addressService.createAddress(payload);
	}
}
