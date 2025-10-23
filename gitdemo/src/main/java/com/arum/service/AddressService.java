package com.arum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arum.entities.*;

@Component

public class AddressService {
	@Autowired
	IAddressPersistence address;
	
	public List<Address> getAddress(){
		return address.findAll();
	}
	
	public Address createAddress(Address payload) {
		return address.save(payload);
	}
}
