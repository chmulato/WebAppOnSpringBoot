package br.com.caracore.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.caracore.collaborator.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	@Query("select l from Login l where l.username = ?1 and l.password = ?2)")
	public Login findByUsernameAndPassword(String username, String password);
				
}
