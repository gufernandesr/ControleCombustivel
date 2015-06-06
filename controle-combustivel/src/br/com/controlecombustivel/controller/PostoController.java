package br.com.controlecombustivel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.controlecombustivel.dao.PostoDao;
import br.com.controlecombustivel.modelo.Posto;

@Controller
public class PostoController {
	

	@RequestMapping("/telaAdiciona")
	public String telaAdiciona(){
		return "posto/adiciona";
	}

	@RequestMapping("/adicionaPosto")
	public String adicionar(Posto posto) {
		PostoDao dao = new PostoDao();
		dao.adiciona(posto);
		return "redirect:listaPostos";

	}

	@RequestMapping("/listaPostos")
	public String listar(Model model) {
		PostoDao dao = new PostoDao();
		model.addAttribute("postos", dao.lista());
		return "posto/lista";

	}
	
	@RequestMapping("/removePosto")
	public String remover(int id){
		PostoDao dao = new PostoDao();
		dao.remove(id);
		return "redirect:listaPostos";
	}
	
	@RequestMapping("/mostraPosto")
	public String mostrar(Model model, int id){
		PostoDao dao = new PostoDao();
		model.addAttribute("posto", dao.buscaId(id));
		return"posto/mostra";
		
	}
	
	@RequestMapping("/alteraPosto")
	public String alterar(Posto posto){
		PostoDao dao = new PostoDao();
		dao.altera(posto);
		return "redirect:listaPostos";
	}

}
