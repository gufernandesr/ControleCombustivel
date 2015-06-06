package br.com.controlecombustivel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlecombustivel.ConnectionFactory;
import br.com.controlecombustivel.modelo.Veiculo;

public class VeiculoDao {

	private Connection con;

	public VeiculoDao() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Veiculo veiculo) {

		try {
			String sql = "insert into veiculos (placa, modelo, montadora, cor, km) values (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getPlaca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setString(3, veiculo.getMontadora());
			stmt.setString(4, veiculo.getCor());
			stmt.setInt(5, veiculo.getKm());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Veiculo> listaVeiculos() {
		try {
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			PreparedStatement stmt = con
					.prepareStatement("select * from veiculos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				veiculos.add(popula(rs));
			}
			rs.close();
			stmt.close();
			return veiculos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(int id) {
		try {
			String sql = "Delete from veiculos where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Veiculo veiculo) {
		try {
			String sql = "update veiculos set modelo = ?, montadora = ?, placa = ?, cor = ?, km = ? where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getMontadora());
			stmt.setString(3, veiculo.getPlaca());
			stmt.setString(4, veiculo.getCor());
			stmt.setInt(5, veiculo.getKm());
			stmt.setInt(6, veiculo.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Veiculo buscaId(int id) {
		String sql = "select * from veiculos where id =?";

		try {
			Veiculo v = new Veiculo();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			v = popula(rs);
			rs.close();
			stmt.close();
			return v;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	private Veiculo popula(ResultSet rs) {
		Veiculo v = new Veiculo();
		try {
			v.setId(Integer.parseInt(rs.getString("id")));
			v.setModelo(rs.getString("modelo"));
			v.setMontadora(rs.getString("montadora"));
			v.setCor(rs.getString("cor"));
			v.setKm(Integer.parseInt(rs.getString("km")));
			v.setPlaca(rs.getString("placa"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return v;
	}

}
