package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Tarefa;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class TarefasController {
	
	private JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao){
		
		this.dao = dao;
	}
	
	@RequestMapping("novaTarefa")
	public String nova() {

		return "/tarefa/Adiciona";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		if (result.hasFieldErrors("descricao")) {

			return "/tarefa/Adiciona";
		}
		
		dao.adiciona(tarefa);

		return "/views/concluido";
	}

	@RequestMapping("listaTarefa")
	public String lista(Model m) {

		m.addAttribute("lista", dao.lista());

		return "tarefa/Lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {

		dao.remove(tarefa);

		return "redirect:listaTarefa";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {

		dao.altera(tarefa);

		return "redirect:listaTarefa";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id){
		
		dao.finaliza(id);
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "redict:formLogin";
	}
}
