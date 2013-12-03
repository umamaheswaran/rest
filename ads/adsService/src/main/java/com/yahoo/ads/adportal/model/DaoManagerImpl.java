package com.yahoo.ads.adportal.model;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yahoo.ads.adportal.entity.Contact;
import com.yahoo.ads.adportal.entity.Customer;

/**
 * @author umatg
 *
 */
public class DaoManagerImpl extends HibernateDaoSupport implements DaoManager {
	
	/* (non-Javadoc)
	 * @see com.yahoo.ads.adportal.model.DaoManager#storeCustomer(com.yahoo.ads.adportal.entity.Customer)
	 */
	public void storeCustomer(Customer customer) throws DataAccessException{
		getHibernateTemplate().save(customer);
	  }
	
	/* (non-Javadoc)
	 * @see com.yahoo.ads.adportal.model.DaoManager#storeCustomer(com.yahoo.ads.adportal.entity.Customer)
	 */
	public void storeContact(Contact contacts) throws DataAccessException{
		getHibernateTemplate().save(contacts);
	  }


}

