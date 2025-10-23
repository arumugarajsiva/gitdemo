package com.arum.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="VENDOR")
public class Vendor {
	@Id
	@Column(nullable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long Id;
	@Column(nullable = false, name = "COMPANY_NAME")
	public String companyName;
	@Column(nullable = false, name = "CONTACT_NAME")
	public String contactName;
	@Column(nullable = false, name = "STATUS")
	public String status;
	@Column(nullable = false, name = "REG_DATE")
	public Date regDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY )
	@JoinColumn(name="vendor", referencedColumnName = "ID")
	private List<Address> addresses = new ArrayList<>();
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Vendor() {
		
	}
	
	public Vendor(Long id, String companyName, String contactName, String status, Date regDate) {
		super();
		Id = id;
		this.companyName = companyName;
		this.contactName = contactName;
		this.status = status;
		this.regDate = regDate;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
