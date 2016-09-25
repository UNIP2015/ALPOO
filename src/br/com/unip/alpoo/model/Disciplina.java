package br.com.unip.alpoo.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private int id;
	private String nome;
	private String aulasPorSemana;
	private String cargaHorario;
	private String codCurso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAulasPorSemana() {
		return aulasPorSemana;
	}
	public void setAulasPorSemana(String aulasPorSemana) {
		this.aulasPorSemana = aulasPorSemana;
	}
	public String getCargaHorario() {
		return cargaHorario;
	}
	public void setCargaHorario(String cargaHorario) {
		this.cargaHorario = cargaHorario;
	}
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public static List<Disciplina> list(){
		List<Disciplina> l = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Disciplina d = new Disciplina();
			d.setCodCurso("1");
			d.setId((i+1));
			d.setAulasPorSemana("2");
			d.setNome("Disciplina " +(i+1));
			d.setCargaHorario("40");
			l.add(d);
					
		}
		return l;
	}
	
	 
}
