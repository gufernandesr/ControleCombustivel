package br.com.controlecombustivel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.controlecombustivel.dao.OleoDao;
import br.com.controlecombustivel.modelo.Oleo;

@Controller
public class OleoController {

	@RequestMapping("/oleo")
	public String indexOleo() {
		return "oleo/adiciona";
	}

	@RequestMapping("/adicionaOleo")
	public String adicionaOleo(Oleo oleo) {
		OleoDao dao = new OleoDao();
		dao.adiciona(oleo);
		return ("redirect:listaOleos");

	}

	@RequestMapping("/listaOleos")
	public String listaOleo(Model model) {
		OleoDao dao = new OleoDao();
		model.addAttribute("oleos", dao.lista());
		return "oleo/lista";
	}
	
	@RequestMapping("/mostraOleo")
	public String mostraOleo(int id, Model model){
		OleoDao dao =  new OleoDao();
		model.addAttribute("oleo", dao.buscaId(id));
		return "oleo/mostra";
	}
	
	@RequestMapping("/alteraOleo")
	public String alteraOleo(Oleo oleo){
		OleoDao dao = new OleoDao();
		dao.altera(oleo);
		return "redirect:listaOleos";
	}
	
	@RequestMapping("removeOleo")
	public String removeOleo(int id){
		OleoDao dao = new OleoDao();
		dao.remove(id);
		return "redirect:listaOleos";
	}

}
