package it.polito.tdp.lab04.model;

public class Corso {
	
	String codins, nome;
	Integer crediti, pd;
	
	public Corso(String codins, Integer crediti, String nome,  Integer pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCrediti() {
		return crediti;
	}

	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}

	public Integer getPd() {
		return pd;
	}

	public void setPd(Integer pd) {
		this.pd = pd;
	}
	
	
}
