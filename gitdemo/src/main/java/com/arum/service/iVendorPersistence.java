package com.arum.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.Query;

import com.arum.entities.Vendor;

public interface iVendorPersistence extends JpaRepository<Vendor, Long> {
	List <Vendor> findByCompanyName(String companyName);
	
	@Query( nativeQuery = true, 
		    value = "SELECT * FROM public.vendor where lower(CONTACT_NAME) like concat('%', lower(?1), '%') ")
	List <Vendor> lookupVendorByName(String contactName);
}
