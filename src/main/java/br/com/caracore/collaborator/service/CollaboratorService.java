package br.com.caracore.collaborator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.caracore.collaborator.model.Collaborator;
import br.com.caracore.collaborator.repository.CollaboratorRepository;

@Service
@Component
public class CollaboratorService {

	@Autowired
	private CollaboratorRepository collaboratorRepository;

	public List<Collaborator> listAll() {
		return collaboratorRepository.findAll();
	}

}
