
package br.com.iniciativa21.ordemservico.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	
	@RequestMapping("/cadastroshailton")
	public String FormCad(HttpSession session) {
		return "sistema/cadastros";
	}
	

	@RequestMapping("/os")
	public String FormOS(HttpSession session) {
		return "sistema/os";
	}
	
	@RequestMapping("/chamados")
	public String FormChamados(HttpSession session) {
		return "sistema/chamados";
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
  			    List<Usuario> u = UsuDao.consultaUsu(usuario);
				Usuario usu = new Usuario();

				  usu.setId_usuario(u.get(0).getId_usuario());
				  usu.setEmail(u.get(0).getEmail());
				  usu.setPermissao(u.get(0).getPermissao());
				  usu.setSenha(u.get(0).getSenha());
				
				  session.setAttribute("usuarioLogado", usu);
				  
				  usu = (Usuario)session.getAttribute("usuarioLogado");
				  req.setAttribute("usuarioLog",usu.getEmail());
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

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}
