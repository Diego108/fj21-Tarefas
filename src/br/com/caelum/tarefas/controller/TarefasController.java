package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
	
	@RequestMapping("novaTarefa")
	public String nova() {

		return "/tarefa/Adiciona";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		if (result.hasFieldErrors("descricao")) {

			return "/tarefa/Adiciona";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);

		return "/views/concluido";
	}

	@RequestMapping("listaTarefa")
	public String lista(Model m) {

		JdbcTarefaDao dao = new JdbcTarefaDao();
		m.addAttribute("lista", dao.lista());

		return "tarefa/Lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {

		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);

		return "redirect:listaTarefa";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {

		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);

		return "redirect:listaTarefa";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id){
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
	}
	
	@RequestMapping("formLogin")
	public String formLogin(){
		
		return "formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		if(new JdbcUsuarioDao().existeUsuario(usuario)){
			
			session.setAttribute("usuarioLogado",usuario);
			return "menu";
		}
		return "redirect:formLogin";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "redict:formLogin";
	}
}
