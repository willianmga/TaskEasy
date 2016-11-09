package br.com.listatarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.listatarefas.dao.JdbcTarefaDao;
import br.com.listatarefas.model.Tarefa;

@Controller
public class TarefasController {
	
	@RequestMapping("novaTarefa")
	public String form() {
		
		return "tarefa/formulario";
		
	}
		
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.inserir(tarefa);
		return "tarefa/tarefa-adicionada";
				
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> tarefas = dao.getAll();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
		
	}

}
