package danny.store.service;

import java.util.List;

import danny.store.entity.*;

import java.util.*;

public class ProdottoServiceImpl implements ProdottoService {
	
	private List<Prodotto> prodottiAttuali = new ArrayList<>();

	@Override
	public List<Prodotto> getProdottiDisponibili() {
		return prodottiAttuali;
	}
	
	@Override
	public void creaProdotto(long idProdotto, String nome, String tipologia, int quantita, double prezzo) {
		Prodotto prodotto = new Prodotto(idProdotto, nome, tipologia, quantita, prezzo);
		aggiungiProdotto(prodotto);
	}

	@Override
	public void aggiungiProdotto(Prodotto prodotto) {
		boolean riempito = controllaCampi(prodotto);
		if (!riempito) {
			System.out.println("Non sono stati riempiti tutti i campi correttamente. Riprova.");
		} else if (riempito) {
			prodottiAttuali.add(prodotto);
		}
	}
	
	@Override
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
	
	@Override
	public void cercaProdotto(String tipologia) {
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
	
	@Override
	public void aggiungiNelCarrello (long idProdotto, Cliente cliente) {
		for (Prodotto p : prodottiAttuali) {
			if (p.getIdProdotto() == idProdotto) {
				System.out.println("Articolo Numero " + idProdotto + " aggiunto nel Carrello.");
				cliente.getCarrello().add(p);
			}
		}
		
		int contatoreCarrello = 0;
		double totaleCarrello = 0.0;
		List<Prodotto> prodottiCarrello = cliente.getCarrello();
		
		for (Prodotto p : prodottiCarrello) {
			p.setQuantita(1);
			contatoreCarrello++;
			totaleCarrello = p.getPrezzo() + totaleCarrello;
		}
		
		System.out.println("Ora hai " + contatoreCarrello + " articoli nel carrello." +
						   "\nIl Totale Stimato è di " + totaleCarrello + "€.");
	}
	
	@Override
	public void visualizzaCarrello(Cliente cliente) {
		int contatoreCarrello = 0;
		double totaleCarrello = 0.0;
		List<Prodotto> prodottiCarrello = cliente.getCarrello();
		
		for (Prodotto p : prodottiCarrello) {
			p.setQuantita(1);
			System.out.println(p);
			contatoreCarrello++;
			totaleCarrello = p.getPrezzo() + totaleCarrello;
		}
		
		if (contatoreCarrello == 0) {
			System.out.println("Non ci sono articoli nel tuo carrello");
		} else {
			System.out.println("Attualmente ci sono " + contatoreCarrello + " articoli nel carrello." +
					   "\nIl Totale Stimato è di " + totaleCarrello + "€.");
		}
	}
	
	@Override
	public void acquistaCarrello(Cliente cliente) {
		double totaleCarrello = 0.0;
		List<Prodotto> prodottiCarrello = cliente.getCarrello();
		for (Prodotto p : prodottiCarrello) {
			totaleCarrello = p.getPrezzo() + totaleCarrello;
		}
		
		Iterator<Prodotto> iter = prodottiCarrello.iterator();
		while(iter.hasNext()) {
			@SuppressWarnings("unused")
			Prodotto prodottoSingolo = iter.next();
			iter.remove();
		}
		
		System.out.println("Hai pagato un totale di " + totaleCarrello + "€. L'indirizzo verrà spedito a : " + cliente.getIndirizzo() + ". Grazie e Arrivederci!");
		visualizzaCarrello(cliente);
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
