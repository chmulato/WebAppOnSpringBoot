package br.com.caracore.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caracore.collaborator.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
				
}
