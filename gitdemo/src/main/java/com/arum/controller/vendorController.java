package com.arum.controller;

//import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arum.entities.Vendor;
import com.arum.service.*;

@RestController

public class vendorController {
	@Autowired
	vendorService vendorService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/vendor")
	public List<Vendor> getVendors(){
		return vendorService.readAllVendors();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.searchByCompanyName(company);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/vendor/lookup/{contact}")
	public List<Vendor> searchByContact(@PathVariable("contact") String contact){
		return vendorService.searchByContactName(contact);
	}
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
			if(!searchResult.isPresent()) {
				return new Vendor();
			}
		return searchResult.get();
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createVendor(myPostBody);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/vendor")
	public Vendor changeVendor(@RequestBody Vendor changeObject) {
		return vendorService.changeVendor(changeObject);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/vendor")
	public String deleteVendor(@PathVariable("id") Long id) {
		return vendorService.deleteVendor(id);
	}
//	private void fillVendors() {
//		vendors.put("1", x);
//		vendors.put("2", y);
//		vendors.put("3", z);
//	}
}
