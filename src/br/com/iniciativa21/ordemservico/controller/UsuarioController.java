package br.com.iniciativa21.ordemservico.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativa21.ordemservico.model.dao.DAOException;
import br.com.iniciativa21.ordemservico.model.dao.UsuarioDAO;
import br.com.iniciativa21.ordemservico.model.entity.Usuario;



@Transactional
@Controller
public class UsuarioController {

	@Autowired
	UsuarioDAO UsuDao;

	@RequestMapping("/")
	public String Form(HttpSession session) {
		return "redirect:loginForm";
	}

	@RequestMapping("loginForm")
	public String loginForm(HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			return "redirect:eflog";
		}
		return "sistema/formulario-login";
	}

	@RequestMapping("eflog")
	public String efetuaLogin(Usuario usuario, HttpSession session,
			HttpServletRequest req) {

		if (session.getAttribute("usuarioLogado") != null) {
			return "sistema/principal";
		}

		try {
			if (!UsuDao.consultaUsu(usuario).isEmpty()) {
				session.setAttribute("usuarioLogado", usuario);
				req.setAttribute("msgErro", null);
				return "sistema/principal";
			} else {
				req.setAttribute("msgErro", "Usuario invalido !");
				return "forward:loginForm";
			}
		} catch (DAOException e) {
			req.setAttribute("msgErro", e.getMessage());
			return "forward:loginForm";
		}
	}

	@RequestMapping("logoutRasa")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}
