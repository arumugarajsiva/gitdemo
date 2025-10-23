package com.arum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arum.entities.Vendor;
import java.util.*;

@Component

public class vendorService {
	@Autowired
	iVendorPersistence vendor;
	
	public List<Vendor> readAllVendors(){
		return vendor.findAll();
	}
	
	public Vendor createVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
	}
	
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	}
	
	public List<Vendor> searchByContactName(String contactName){
		return vendor.lookupVendorByName(contactName);
	}
	
	public Optional<Vendor> getSingleVendor(Long id) {
		return vendor.findById(id);
	}
	
	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if (!myVendor.isPresent()) {
			return new Vendor();
		}
		return vendor.save(payload);
	}
	
	public String deleteVendor(Long id) {
		vendor.deleteById(id);
		return "Deleted";
	}
}
