package br.com.controlecombustivel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.controlecombustivel.dao.ControleCombustivelDao;
import br.com.controlecombustivel.dao.PostoDao;
import br.com.controlecombustivel.dao.VeiculoDao;

@Controller
public class ControllerGeral {

	@RequestMapping("/index")
	public String index() {
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return"home";
	}
	
	@RequestMapping("controleComb")
	public String controleCombe(Model model){
		VeiculoDao vdao = new VeiculoDao();
		PostoDao pdao = new PostoDao();
		model.addAttribute("veiculos", vdao.listaVeiculos());
		model.addAttribute("postos",pdao.lista());
		return "controle_comb/adiciona";
	}
	
	@RequestMapping("listaControleComb")
	public String listaControleComb(Model model){
		VeiculoDao vdao = new VeiculoDao();
		PostoDao pdao = new PostoDao();
		ControleCombustivelDao dao = new ControleCombustivelDao();
		
		model.addAttribute("veiculos", vdao.listaVeiculos());
		model.addAttribute("postos",pdao.lista());
		model.addAttribute("combustivel", dao.listaControleCombustivel());
		return "controle_comb/lista";
	}
}
