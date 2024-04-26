//CLASSE PARA MODULAÇÃO DO OBJETO CLIENTE
package br.edu.senaisp.model;

import java.util.ArrayList;

public class Cliente {

	//ATRIBUTOS DA CLASSE
	private Integer id; //CHAVE PRIMARIA 
	private String nome;
	private String cpf;
	private	ArrayList<Carro> carros; //VÍNCULO COM OS CARROS
	
	//MÉTODOS GETTERS E SETTERS
	public ArrayList<Carro> getCarros() {
		return carros;
	}

	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
