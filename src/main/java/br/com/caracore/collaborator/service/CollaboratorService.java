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

	final private String FILTER_ALL = "%";
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;

	public List<Collaborator> listAll() {
		return collaboratorRepository.findAll();
	}

	public Collaborator buscar(Long codigo) {
		return collaboratorRepository.findOne(codigo);
	}

	public List<Collaborator> filtrar(CollaboratorFilter filter) {
		List <Collaborator> listar = null;
		String name = FILTER_ALL;
		String description = FILTER_ALL;
		if (filter != null) {
			if (filter.getName() != null) {
				name = filter.getName();
			}
			if (filter.getDescription() != null) {
				name = filter.getDescription();
			}
			listar = collaboratorRepository.findByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(name, description);
		}
		return listar;
	}

	public void salvar(Collaborator collaborator) {
		collaboratorRepository.save(collaborator);
	}

	public void excluir(Long codigo) {
		collaboratorRepository.delete(codigo);
		
	}
}
