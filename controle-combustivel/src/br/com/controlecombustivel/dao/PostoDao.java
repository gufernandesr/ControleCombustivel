package br.com.controlecombustivel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlecombustivel.ConnectionFactory;
import br.com.controlecombustivel.modelo.Posto;

public class PostoDao {

	private Connection con;

	public PostoDao() {
		try {
			con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Posto posto) {

		try {
			String sql = "insert into postos (nome, bandeira, endereco) values (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, posto.getNome());
			stmt.setString(2, posto.getBandeira());
			stmt.setString(3, posto.getEndereco());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Posto> lista() {
		try {
			List<Posto> postos = new ArrayList<Posto>();
			PreparedStatement stmt = con
					.prepareStatement("select * from postos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				postos.add(popula(rs));
			}
			rs.close();
			stmt.close();
			return postos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("delete from postos where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Posto posto) {
		try {
			String sql = "update postos set nome = ?, bandeira = ?, endereco = ? where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, posto.getNome());
			stmt.setString(2, posto.getBandeira());
			stmt.setString(3, posto.getEndereco());
			stmt.setInt(4, posto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Posto buscaId(int id) {
		try {
			Posto p = new Posto();
			PreparedStatement stmt = con
					.prepareStatement("select * from postos where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			p = popula(rs);
			rs.close();
			stmt.close();

			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Posto popula(ResultSet rs) {
		Posto p = new Posto();
		try {
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setBandeira(rs.getString("bandeira"));
			p.setEndereco(rs.getString("endereco"));
			p.setNome(rs.getString("nome"));

			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
