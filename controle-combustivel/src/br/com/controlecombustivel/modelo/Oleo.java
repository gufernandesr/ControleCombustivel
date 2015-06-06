package br.com.controlecombustivel.modelo;

public class Oleo {

	private int id;
	private String marca;
	private String tipo;
	private String classificacao;
	private int duracaoKm;
	private int litragem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public int getDuracaoKm() {
		return duracaoKm;
	}

	public void setDuracaoKm(int duracaoKm) {
		this.duracaoKm = duracaoKm;
	}

	public int getLitragem() {
		return litragem;
	}

	public void setLitragem(int litragem) {
		this.litragem = litragem;
	}

}
