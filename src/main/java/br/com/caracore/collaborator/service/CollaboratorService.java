package br.com.caracore.collaborator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.caracore.collaborator.model.Collaborator;
import br.com.caracore.collaborator.repository.CollaboratorRepository;
import br.com.caracore.collaborator.repository.filter.CollaboratorFilter;

@Service
@Component
public class CollaboratorService {

	@Autowired
	private CollaboratorRepository collaboratorRepository;

	public List<Collaborator> listAll() {
		return collaboratorRepository.findAll();
	}

	public Collaborator buscar(Long codigo) {
		return collaboratorRepository.findOne(codigo);
	}

	public List<Collaborator> filtrar(CollaboratorFilter filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Collaborator collaborator) {
		collaboratorRepository.save(collaborator);
	}

	public void excluir(Long codigo) {
		collaboratorRepository.delete(codigo);
		
	}

	public String receber(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
