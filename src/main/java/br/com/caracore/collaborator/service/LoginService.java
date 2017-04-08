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
	
	public List<Login> listAll() {
		return loginRepository.findAll();
	}

	public String validar() {
		return "TESTE";
	}
}
