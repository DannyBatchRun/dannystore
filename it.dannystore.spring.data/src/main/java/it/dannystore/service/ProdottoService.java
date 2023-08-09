package it.dannystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dannystore.model.*;
import it.dannystore.repository.ProdottoRepository;

import java.util.*;

@Service

public class ProdottoService {
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	private List<Prodotto> prodottiAttuali = new ArrayList<>();

	public List<Prodotto> getProdottiDisponibili() {
		List<Prodotto> prodottiAttuali = (List<Prodotto>) prodottoRepository.findAll();
		return prodottiAttuali;
	}
	
	public void creaProdotto(String nome, String tipologia, int quantita, double prezzo) {
		Prodotto prodotto = new Prodotto(nome, tipologia, quantita, prezzo);
		aggiungiProdotto(prodotto);
		savePersistProdotto(prodotto);
	}
	
	public void savePersistProdotto (Prodotto prodotto) {
		prodottoRepository.save(prodotto);
	}
	
	public void getProdottoFromPersistentData (long idCliente) {
		prodottoRepository.findById(idCliente);
	}

	public void aggiungiProdotto(Prodotto prodotto) {
		boolean riempito = controllaCampi(prodotto);
		if (!riempito) {
			System.out.println("Non sono stati riempiti tutti i campi correttamente. Riprova.");
		} else if (riempito) {
			prodottiAttuali.add(prodotto);
		}
	}
	
	public void rimuoviProdotto(long idProdotto) {
		for (Prodotto p : prodottiAttuali) {
			if(p.getIdProdotto() == idProdotto) {
				System.out.println("Si sta rimuovendo il seguente prodotto.\n" + p);
			}
		}
		
		Iterator<Prodotto> prod = prodottiAttuali.iterator();
		while(prod.hasNext()) {
			Prodotto p = prod.next();
			if (p.getIdProdotto() == idProdotto) {
				prod.remove();
				System.out.println("Prodotto Rimosso");
			}
		}
	}

	public void cercaProdotto(String tipologia) {
		prodottiAttuali = (List<Prodotto>) prodottoRepository.findAll();
		boolean nonTrovato = true;
		System.out.println("\n");
		for (Prodotto p : prodottiAttuali) {
			if (p.getTipologia().equals(tipologia)) {
				System.out.println(p);
				nonTrovato = false;
			} 
		}
		if (nonTrovato) {
			System.out.println("\nNon è stato trovato alcun prodotto con tipologia " + tipologia);
		} else if (!nonTrovato) {
			System.out.println("\nLa ricerca ha prodotto questi risultati");
		}
	}
	
	private boolean controllaCampi(Prodotto prodotto) {
		boolean riempito = false;
		if (prodotto.getIdProdotto() != 0 || prodotto.getNome() != null ||
			prodotto.getPrezzo() != 0 || prodotto.getQuantita() != 0 ||
			prodotto.getTipologia() != null) {
			riempito = true;
		}
		return riempito;
	}
	
}
