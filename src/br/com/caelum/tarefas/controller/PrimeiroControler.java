package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrimeiroControler {

	@RequestMapping("/PrimeiroController")
	public String executa(){
		
		return "concluido";
	}
}
