package br.com.unip.alpoo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Professor {
	private int id;
	private String nome;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String dataNascimento;
	private String especialidades;
	private String titulo;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public static List<Professor> list(){
		List<Professor> list = new ArrayList<>();
		String[] ufs = new String[]{
				"AC","AL","AP","AM","BA",
				"CE","DF","ES","GO","MA",
				"MT","MS","MG","PR","PB",
				"PA","PE","PI","RJ","RN",
				"RS","RO","RR","SC","SE",
				"SP","TO"
		};
		String[] especialidades = new String[]{
				"Direito","Informatica",
				"Matematica", "Medicina"
		};
		String[] titulos = new String[]{
				"Especialista Lato Sensu","Mestrado",
				"Doutorado"
		};
		for(int i = 0; i < 20; i++){
			Professor p = new Professor();
			p.setId((i+1));
			p.setNome("Professor " + (i+1));
			p.setBairro("Vila Dexcubra "+(i+1));
			p.setEndereco("Rua Lorem");
			p.setNumero("nº"+(i+1));
			p.setTelefone("(11) 1212-2323");
			p.setDataNascimento("11/02/1990");
			p.setCidade("Cidade DEXCUBRA");
			
			Random r = new Random();
			int index = r.nextInt(ufs.length);
			p.setEstado(ufs[index]);
			
			r = new Random();
			index = r.nextInt(especialidades.length);
			p.setEspecialidades(especialidades[index]);
			
			r = new Random();
			index = r.nextInt(titulos.length);
			p.setTitulo(titulos[index]);
			
			
			list.add(p);
		}
		
		return list;
	}
}
