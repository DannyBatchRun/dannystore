package it.dannystore.entity;

import java.util.*;

public class Cliente {
	
	private long idCliente;
	private String nome;
	private String cognome;
	private String indirizzo;
	private List<Prodotto> carrello = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(long idCliente, String nome, String cognome, String indirizzo) {
		this.idCliente = idCliente;
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

	public List<Prodotto> getCarrello() {
		return carrello;
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

	public void setCarrello(List<Prodotto> carrello) {
		this.carrello = carrello;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo="
				+ indirizzo + "]";
	}
	
	

}
