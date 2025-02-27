package com.fpoly.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.fpoly.model.Contact;
import com.fpoly.repository.ContactRepository;

@Service
public class ContactService {
	private final ContactRepository cr;
	
	public ContactService(ContactRepository ctR) {
		this.cr = ctR;
	}
	
	public List<Contact> getAll(){
		return cr.findAll();
	}
	
	public Contact add(Contact c) {
		return cr.save(c);
	}
	
	public void delete(int id) {
		cr.deleteById(id);
	}	
}
