package com.fpoly.service;

import com.fpoly.model.Contact;
import com.fpoly.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepo;

    // Tiêm repository qua constructor
    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }
    
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }
    
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }
    
    public Contact getContactById(int id) {
        Optional<Contact> optional = contactRepo.findById(id);
        return optional.orElse(null);
    }
    
    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }
    
    public void deleteContact(int id) {
    	contactRepo.deleteById(id);
    }
}
