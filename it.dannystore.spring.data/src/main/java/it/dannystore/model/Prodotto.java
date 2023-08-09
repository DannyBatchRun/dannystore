package it.dannystore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Prodotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProdotto;
	private String nome;
	private String tipologia;
	private int quantita;
	private double prezzo;
	
	public Prodotto() {
		
	}

	public Prodotto(String nome, String tipologia, int quantita, double prezzo) {
		this.nome = nome;
		this.tipologia = tipologia;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public long getIdProdotto() {
		return idProdotto;
	}

	public String getNome() {
		return nome;
	}

	public String getTipologia() {
		return tipologia;
	}

	public int getQuantita() {
		return quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setIdProdotto(long idProdotto) {
		this.idProdotto = idProdotto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Codice Prodotto " + idProdotto + ". Nome : " + nome + ", Tipologia " + tipologia + ", "
				+ quantita + " pezzi. Il prezzo è di " + prezzo + "€.";
	}

}
