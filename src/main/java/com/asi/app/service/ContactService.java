package com.asi.app.service;

import com.asi.app.entity.Contact;
import com.asi.app.entity.User;
import com.asi.app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact){
       return contactRepository.save(contact);
    }

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id){
        return contactRepository.getReferenceById(id);
    }
}
