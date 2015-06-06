package br.com.controlecombustivel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.controlecombustivel.dao.UsuarioDao;
import br.com.controlecombustivel.modelo.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/novoUsuario")
	public String novoUsuario(){
		return "usuario/adiciona";
	}
	
	@RequestMapping("/adicionaUsuario")
	public String adicionaUsuario(Usuario usuario){
		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(usuario);
		return "redirect:novoUsuario";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logar")
	public String logar(Usuario usuario, HttpSession session, Model model){
		UsuarioDao dao = new UsuarioDao();
		if(dao.existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		}
		model.addAttribute("mensagem", "Usuario ou senha invalidos");
		return "login";
		
		
	}
}
