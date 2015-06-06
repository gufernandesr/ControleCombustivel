package br.com.controlecombustivel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.controlecombustivel.dao.VeiculoDao;
import br.com.controlecombustivel.modelo.Veiculo;

@Controller
public class VeiculoController {
	
	//VeiculoDao dao;
	
	@RequestMapping("/veiculo")
	public String posto(){
		return "veiculo/adicionaVeiculo";
	}
	
	@RequestMapping("/adicionaVeiculo")
	public String adicionar(Veiculo veiculo){
		VeiculoDao dao = new VeiculoDao();
		dao.adiciona(veiculo);
		return "redirect:listaVeiculos";
	}
	
	@RequestMapping("/listaVeiculos")
	public String listar(Model model){
		VeiculoDao dao = new VeiculoDao();
		model.addAttribute("veiculos", dao.listaVeiculos());
		return "veiculo/lista";
	}
	
	@RequestMapping("/mostraVeiculo")
	public String mostra(Model model, int id){
		VeiculoDao dao = new VeiculoDao();
		model.addAttribute("veiculo", dao.buscaId(id));
		return "veiculo/mostra";
		
	}
	
	@RequestMapping("/alteraVeiculo")
	public String altera(Veiculo veiculo){
		VeiculoDao dao = new VeiculoDao();
		dao.altera(veiculo);
		return "redirect:listaVeiculos";
	}
	
	@RequestMapping("/removeVeiculo")
	public String remove (int id){
		VeiculoDao dao = new VeiculoDao();
		dao.remove(id);
		return "redirect:listaVeiculos";
	}

}
