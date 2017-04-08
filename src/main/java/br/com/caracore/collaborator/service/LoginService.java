package br.com.caracore.collaborator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.caracore.collaborator.model.Login;
import br.com.caracore.collaborator.repository.LoginRepository;

@Service
@Component
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public boolean validate(String username, String password) {
		boolean validate = false;
		Login login = loginRepository.findByUsernameAndPassword(username, password);
		if (login != null) {
			validate = true;
		}
		return validate;
	}

	public List<Login> buscarTodos() {
		return loginRepository.findAll();
	}
}
