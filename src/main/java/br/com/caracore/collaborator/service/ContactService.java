package br.com.caracore.collaborator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.caracore.collaborator.model.Contact;
import br.com.caracore.collaborator.repository.ContactRepository;

@Service
@Component
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> listAll() {
		return contactRepository.findAll();
	}

}
