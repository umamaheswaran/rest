package com.yahoo.ads.adportal.services;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.yahoo.ads.adportal.entity.Contact;
import com.yahoo.ads.adportal.entity.CustContact;
import com.yahoo.ads.adportal.entity.Customer;
import com.yahoo.ads.adportal.model.DaoManagerImpl;

@Path("/customer")
@Component
@Scope("request")
public class CustomerService {
	private DaoManagerImpl daoManagerTarget;
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public DaoManagerImpl getDaoManagerImpl() {
		return daoManagerTarget;
	}

	public void setDaoManagerImpl(DaoManagerImpl daoManagerTarget) {
		this.daoManagerTarget = daoManagerTarget;
	}

	@POST
    @Path("add")
    @Consumes("text/plain")
	public void addCustomer() {
		Customer customer = new Customer();
		customer.setCustomername("ToGo");
		customer.setLocation("Pleasanton");
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		daoManagerTarget.storeCustomer(customer);
		//sendMail(customer);
	}
	
	@POST
    @Path("addCust")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCust(@RequestBody CustContact cust) {
		Customer customer = new Customer();
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		customer.setCustomername(cust.getCustomername());
		customer.setLocation(cust.getLocation());
		
		Contact contacts = new Contact();
		contacts.setFirstName(cust.getFirstName());
		contacts.setLastName(cust.getLastName());
		contacts.setEmail(cust.getEmail());
		contacts.setAddr1(cust.getAddr1());
		contacts.setAddr2(cust.getAddr2());
		contacts.setCity(cust.getCity());
		contacts.setCountry(cust.getCountry());
		contacts.setPwd(cust.getPwd());
		contacts.setCustomer(customer);
		
		daoManagerTarget.storeCustomer(customer);
		daoManagerTarget.storeContact(contacts);
		sendMail(contacts);
		
	}


	public void sendMail(final Contact contacts) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)
					throws MessagingException {
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(contacts.getEmail()));
				mimeMessage.setFrom(new InternetAddress(""));
				mimeMessage.setSubject("test mail");
				mimeMessage.setText("Dear " +
				contacts.getLastName() +
				"Your account created, please click the below link to activate your account" + 
				" thank you ");
			}
		};
		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			// log it and go on
			System.err.println(ex.getMessage());
		}
	}

}
