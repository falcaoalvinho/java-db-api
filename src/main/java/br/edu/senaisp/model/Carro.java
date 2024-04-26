//CLASSE PARA MODULAÇÃO DO OBJETO CARRO
package br.edu.senaisp.model;

public class Carro {
	
	//ATRIBUTOS DA CLASSE
	private Integer id; //CHAVE PRIMARIA
	private String marca;
	private String modelo;
	private Cliente proprietario; //VÍNCULO COM O PROPRIETÁRIO
	
	//MÉTODOS GETTERS E SETTERS
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Cliente getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}
	

	
}
