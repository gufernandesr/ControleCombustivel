package br.com.controlecombustivel.modelo;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class ControleCombustivel {

	private int id;
	private int idVeiculo;
	private int idPosto;
	private double litros;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar data;
	private double kmInicial;
	private double kmFinal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getKmInicial() {
		return kmInicial;
	}

	public void setKmInicial(double kmInicial) {
		this.kmInicial = kmInicial;
	}

	public double getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}

}
