package it.dannystore.service;

import java.util.*;
import it.dannystore.model.*;

public interface ProdottoService {
	
	public List<Prodotto> getProdottiDisponibili();
	public void creaProdotto(String nome, String tipologia, int quantita, double prezzo);
	public void savePersistProdotto(Prodotto prodotto);
	public void getProdottoFromPersistentData (long idProdotto);
	public void aggiungiProdotto (Prodotto prodotto);
	public void rimuoviProdotto (long idProdotto);
	public void cercaProdotto(String tipologia);
	
}
