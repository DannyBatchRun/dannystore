package danny.store.service;

import java.util.*;

import danny.store.entity.*;

public interface ProdottoService {
	
	public List<Prodotto> getProdottiDisponibili(); 
	public void creaProdotto(long idProdotto, String nome, String tipologia, int quantita, double prezzo);
	public void aggiungiProdotto(Prodotto prodotto);
	public void rimuoviProdotto(long idProdotto);
	public void cercaProdotto(String nome);
	public void aggiungiNelCarrello (long idProdotto, Cliente cliente);
	public void visualizzaCarrello(Cliente cliente);
	public void acquistaCarrello(Cliente cliente);

}
