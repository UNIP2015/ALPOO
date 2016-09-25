package br.com.unip.alpoo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public static List<Curso> getListCursos(){
		List<Curso> list = new ArrayList();
		String[] cursos = new String[]{
				"Administração de Empresa",
				"Bio Medicia",
				"Ciências Biologicas",
				"Ciência da Computação",
				"Direito",
				"Educação Fisica",
				"Farmacologia",
				"Rede de Computadores",
				"Sistema de Informações"
		};
		for(int i = 0; i < 10; i++){
			Curso c = new Curso();
			Random r = new Random();
			
			c.setNome(cursos[r.nextInt(cursos.length)]);
			c.setCargaHoraria(100);
			c.setId((i+1));
			c.setTipo("Bacharel");
			c.setCodInstitulo(1);
			list.add(c);
		}
		
		return list;
	}
	
	
}
