package br.com.controlecombustivel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.controlecombustivel.dao.ControleCombustivelDao;
import br.com.controlecombustivel.dao.PostoDao;
import br.com.controlecombustivel.modelo.ControleCombustivel;

@Controller
public class ControleCombustivelController {

	@RequestMapping("/adicionaControleComb")
	public String adicionaControleComb(ControleCombustivel comb) {
		ControleCombustivelDao dao = new ControleCombustivelDao();
		dao.adiciona(comb);
		return ("controle_comb/adiciona");
	}

	/*
	 * @RequestMapping("/listaControleComb") public String
	 * listaControleCombr(Model model){ ControleCombustivelDao dao = new
	 * ControleCombustivelDao(); model.addAttribute("combustivel",
	 * dao.listaControleCombustivel()); return "controle_comb/lista"; }
	 */

	@RequestMapping("/mostraControleComb")
	public String mostraControleCombustivel(Model model, int id) {
		ControleCombustivelDao dao = new ControleCombustivelDao();
		PostoDao pdao = new PostoDao();
		model.addAttribute("postos", pdao.lista());
		model.addAttribute("controle", dao.buscaId(id));

		return "controle_comb/mostra";
	}

	@RequestMapping("/alteraControleComb")
	public String alteraControleComb(ControleCombustivel comb) {
		ControleCombustivelDao dao = new ControleCombustivelDao();
		dao.altera(comb);
		return "redirect:listaControleComb";
	}

	@RequestMapping("/removeControleComb")
	public String removeControleComb(int id) {
		ControleCombustivelDao dao = new ControleCombustivelDao();
		dao.exclui(id);
		return "redirect:listaControleComb";
	}
}
