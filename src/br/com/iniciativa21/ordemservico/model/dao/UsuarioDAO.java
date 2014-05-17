package br.com.iniciativa21.ordemservico.model.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.iniciativa21.ordemservico.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	
	@PersistenceContext
	EntityManager manager;

	public List<Usuario> consultaUsu(Usuario usuario) throws DAOException {
		try {
			TypedQuery<Usuario> query = manager.createQuery(
					"SELECT u FROM Usuario u " + "WHERE u.email = :email  "
							+ " AND u.senha  = :senha ", Usuario.class);

			query.setParameter("email", usuario.getEmail().toString());
			query.setParameter("senha", usuario.getSenha().toString());
			List<Usuario> u = query.getResultList();

			return u;

		} catch (Exception r) {
			//throw new DAOException("Erro de SQL ao validar Usuario !!! : "+r);
			throw new DAOException("Erro ao validar Usuario !");
		}

	}
}
