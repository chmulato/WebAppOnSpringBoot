package br.com.caracore.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caracore.collaborator.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
				
}
