package br.com.caracore.collaborator.controller;

	
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caracore.collaborator.model.Collaborator;
import br.com.caracore.collaborator.model.StatusCollaborator;
import br.com.caracore.collaborator.repository.filter.CollaboratorFilter;
import br.com.caracore.collaborator.service.CollaboratorService;

@Controller
@RequestMapping("/colaboradores")
public class CollaboratorController {
	
	private static final String CADASTRO_VIEW = "CadastroColaborador";
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject("todosStatusTitulo", StatusCollaborator.values());
		mv.addObject(new Collaborator());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Collaborator titulo, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		try {
			collaboratorService.salvar(titulo);
			attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
			return "redirect:/titulos/novo";
		} catch (IllegalArgumentException ex) {
			errors.rejectValue("dataVencimento", null, ex.getMessage());
			return CADASTRO_VIEW;
		}
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") CollaboratorFilter filtro) {
		List<Collaborator> collaborators = collaboratorService.filtrar(filtro);
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("collaborators", collaborators);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo) {
		Collaborator collaborator = collaboratorService.buscar(codigo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(collaborator);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		collaboratorService.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return "redirect:/titulos";
	}
	
	
	@RequestMapping(value= "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo) {
		return collaboratorService.receber(codigo);
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusCollaborator> todosStatusTitulo() {
		return Arrays.asList(StatusCollaborator.values());
	}
}
