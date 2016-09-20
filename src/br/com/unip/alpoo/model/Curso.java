package br.com.unip.alpoo.model;

public class Curso {
	private int id;
	private String nome;
	private String tipo;
	private int cargaHoraria;
	private int codInstitulo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public int getCodInstitulo() {
		return codInstitulo;
	}
	public void setCodInstitulo(int codInstitulo) {
		this.codInstitulo = codInstitulo;
	}
	
	
}
