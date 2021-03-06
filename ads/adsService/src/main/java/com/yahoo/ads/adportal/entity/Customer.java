package com.yahoo.ads.adportal.entity;

// Generated Apr 12, 2012 4:50:06 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Integer customerid;
	private String customername;
	private String location;
	private Date createDate;
	private Date lastUpdate;
	private Set<Contact> contacts = new HashSet<Contact>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Customer() {
	}

	public Customer(String customername, String location, Date createDate,
			Date lastUpdate, Set<Contact> contacts, Set<Product> products) {
		this.customername = customername;
		this.location = location;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.contacts = contacts;
		this.products = products;
	}

	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
