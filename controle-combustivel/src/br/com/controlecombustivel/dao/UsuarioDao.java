package br.com.controlecombustivel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.controlecombustivel.ConnectionFactory;
import br.com.controlecombustivel.modelo.Usuario;

public class UsuarioDao {

	Connection con;

	public UsuarioDao() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void adiciona(Usuario usuario) {
		try {
			String sql = "insert into usuarios (usuario, senha) VALUES (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscaUsuario(Usuario usuario) {
		try {
			String sql = "select * from usuarios where usuario = ? and senha = ?";
			Usuario usr = new Usuario();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			rs.next();
			usr = popula(rs);
			rs.close();
			stmt.close();
			return usr;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Usuario popula(ResultSet rs) {
		try {
			Usuario usr = new Usuario();
			usr.setUsuario(rs.getString("usuario"));
			usr.setSenha(rs.getString("senha"));

			return usr;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from usuarios where usuario = ? and senha = ?");
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rs.close();
				return true;

			} else {
				rs.close();
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
