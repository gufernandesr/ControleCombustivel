package br.com.controlecombustivel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlecombustivel.ConnectionFactory;
import br.com.controlecombustivel.modelo.Oleo;

public class OleoDao {

	Connection con;

	public OleoDao() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Oleo oleo) {
		try {
			String sql = "insert into oleos (marca, tipo, classificacao, duracaoKm, litragem) values (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, oleo.getMarca());
			stmt.setString(2, oleo.getTipo());
			stmt.setString(3, oleo.getClassificacao());
			stmt.setInt(4, oleo.getDuracaoKm());
			stmt.setInt(5, oleo.getLitragem());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Oleo> lista() {
		try {
			List<Oleo> oleos = new ArrayList<Oleo>();
			PreparedStatement stmt = con
					.prepareStatement("select * from oleos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				oleos.add(popula(rs));

			}
			rs.close();
			stmt.close();
			return oleos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Oleo oleo) {
		try {
			String sql = "update oleos set marca = ?, tipo = ?, classificacao = ?, duracaoKm = ?, litragem = ? where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, oleo.getMarca());
			stmt.setString(2, oleo.getTipo());
			stmt.setString(3, oleo.getClassificacao());
			stmt.setInt(4, oleo.getDuracaoKm());
			stmt.setInt(5, oleo.getLitragem());
			stmt.setInt(6, oleo.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Oleo buscaId(int id) {
		try {
			Oleo o = new Oleo();

			PreparedStatement stmt = con
					.prepareStatement("select * from oleos where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			o = popula(rs);
			rs.close();
			stmt.close();
			return o;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("delete from oleos where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Oleo popula(ResultSet rs) {
		Oleo o = new Oleo();
		try {
			o.setClassificacao(rs.getString("classificacao"));
			o.setDuracaoKm(Integer.parseInt(rs.getString("duracaoKm")));
			o.setId(Integer.parseInt(rs.getString("id")));
			o.setLitragem(Integer.parseInt(rs.getString("litragem")));
			o.setMarca(rs.getString("marca"));
			o.setTipo(rs.getString("tipo"));

			return o;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
