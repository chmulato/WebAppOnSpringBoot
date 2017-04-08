package br.com.caracore.collaborator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caracore.collaborator.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

	public List<Collaborator> findByNameContainingIgnoreCase(String name);
				
}
