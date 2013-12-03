package com.yahoo.ads.adportal.model;

import org.springframework.dao.DataAccessException;

import com.yahoo.ads.adportal.entity.Contact;
import com.yahoo.ads.adportal.entity.Customer;

/**
 * 
 */
public interface DaoManager {
	public void storeCustomer(Customer customer) throws DataAccessException;
	//public void storeProduct(Product product) throws DataAccessException;
	public void storeContact(Contact contact) throws DataAccessException;
}
