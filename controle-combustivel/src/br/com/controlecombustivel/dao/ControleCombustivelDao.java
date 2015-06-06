package br.com.controlecombustivel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.controlecombustivel.ConnectionFactory;
import br.com.controlecombustivel.modelo.ControleCombustivel;

public class ControleCombustivelDao {

	Connection con;

	public ControleCombustivelDao() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void adiciona(ControleCombustivel comb) {
		try {
			String sql = "insert into controle_comb (idVeiculo, idPosto, litros, data, kmInicial, kmFinal) values (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, comb.getIdVeiculo());
			stmt.setInt(2, comb.getIdPosto());
			stmt.setDouble(3, comb.getLitros());
			// stmt.setDate(4, new
			// Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setDate(4, new Date(comb.getData().getTimeInMillis()));
			stmt.setDouble(5, comb.getKmInicial());
			stmt.setDouble(6, comb.getKmFinal());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<ControleCombustivel> listaControleCombustivel() {
		try {
			List<ControleCombustivel> lista = new ArrayList<ControleCombustivel>();
			PreparedStatement stmt = con
					.prepareStatement("Select * from controle_comb");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(popula(rs));
			}
			rs.close();
			stmt.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ControleCombustivel buscaId(int id) {
		try {
			ControleCombustivel comb = new ControleCombustivel();
			PreparedStatement stmt = con
					.prepareStatement("select * from controle_comb where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			comb = popula(rs);
			rs.close();
			stmt.close();
			return comb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera (ControleCombustivel comb){
		try{
			String sql = "update controle_comb set idVeiculo = ?, idPosto = ?, litros = ?, data = ?, kmInicial = ?, kmFinal = ? where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, comb.getIdVeiculo());
			stmt.setInt(2, comb.getIdPosto());
			stmt.setDouble(3, comb.getLitros());
			stmt.setDate(4, new Date(comb.getData().getTimeInMillis()));
			stmt.setDouble(5, comb.getKmInicial());
			stmt.setDouble(6, comb.getKmFinal());
			stmt.setInt(7, comb.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void exclui (int id){
		try{
			PreparedStatement stmt = con.prepareStatement("delete from controle_comb where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	private ControleCombustivel popula(ResultSet rs) {
		ControleCombustivel comb = new ControleCombustivel();
		try {
			comb.setId(Integer.parseInt(rs.getString("id")));
			comb.setIdPosto(rs.getInt("idPosto"));
			comb.setIdVeiculo(rs.getInt("idVeiculo"));
			comb.setKmFinal(rs.getDouble("kmFinal"));
			comb.setKmInicial(rs.getDouble("kmInicial"));
			comb.setLitros(rs.getDouble("litros"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			comb.setData(data);

			return comb;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
