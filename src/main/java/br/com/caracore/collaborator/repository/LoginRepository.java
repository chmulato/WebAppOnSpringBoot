package br.com.caracore.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caracore.collaborator.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
				
}
