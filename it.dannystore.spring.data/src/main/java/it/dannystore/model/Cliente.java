package it.dannystore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCliente;
	private String nome;
	private String cognome;
	private String indirizzo;
	private double totaleCarrello;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cognome, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
	
	public double getTotaleCarrello() {
		return totaleCarrello;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public void setTotaleCarrello(double totaleCarrello) {
		this.totaleCarrello = totaleCarrello;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo="
				+ indirizzo + "]";
	}
	
	

}
