package com.arum.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arum.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, Long> {

}
