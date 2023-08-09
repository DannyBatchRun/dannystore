package danny.store;

import java.util.*;

import danny.store.entity.*;
import danny.store.service.*;

public class TestApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		DannyStore dannyStore = new DannyStore();
		
		dannyStore.setProdottoServiceImpl(new ProdottoServiceImpl());
		dannyStore.setClienteServiceImpl(new ClienteServiceImpl());

		System.out.println("Benvenuti nel nostro DannyStore! Stiamo caricando tutti i prodotti disponibili.");
		long idProdotto = 3304055;
		String nome = "TV Samser";
		String tipologia = "Televisore";
		int quantita = 345;
		double prezzo = 500.0;
		
		dannyStore.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);
		
		idProdotto = 30405060;
		nome = "Samser Galaxier V22 Mega";
		tipologia = "Smartphone";
		quantita = 3456;
		prezzo = 1000.0;
		
		dannyStore.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);
		
		idProdotto = 3495966;
		nome = "Tobisha";
		tipologia = "Televisore";
		quantita = 222;
		prezzo = 345;
		
		dannyStore.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);

		List<Prodotto> prodotti = dannyStore.getProdottiDisponibili();
		
		System.out.println("\nAl momento abbiamo questi prodotti : \n");
		for (Prodotto p : prodotti) {
			System.out.println(p);
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nRegistrati per effettuare Acquisti. Inserisci i tuoi dati personali.\nInserisci l'ID Utente");
		long idCliente = scanner.nextLong();
		System.out.println("\nInserisci il nome");
		String nomeCliente = scanner.next();
		System.out.println("\nInserisci il cognome");
		Scanner scanner2 = new Scanner(System.in);
		String cognomeCliente = scanner2.next();
		System.out.println("\nE infine, inserisci l'indriizzo");
		Scanner scanner3 = new Scanner(System.in);
		String indirizzoCliente = scanner3.nextLine();
		System.out.println("\nPerfetto! Adesso effettuo la registrazione.");
		
		dannyStore.creaCliente(idCliente, nomeCliente, cognomeCliente, indirizzoCliente);
		
		System.out.println("\nOra che ti sei registrato, puoi procedere.");
		Cliente cliente = dannyStore.getCliente(idCliente);
		boolean entraNelCiclo = true;
		
		while(entraNelCiclo) {
			System.out.println("Che cosa vuoi fare?");
			System.out.println("Scrivi 'Acquista' per acquistare i tuoi prodotti.");
			System.out.println("Scrivi 'Aggiungi' per aggiungere un articolo nel carrello");
			System.out.println("Scrivi 'Visualizza' per visualizzare il tuo carrello");
			System.out.println("Scrivi 'Cerca' per cercare uno o più prodotti");
			System.out.println("Scrivi 'Esci' per uscire dal programma");
			Scanner sceltaScan = new Scanner(System.in);
			String scelta = sceltaScan.next();
			
			if (scelta.equalsIgnoreCase("Esci")) {
				System.out.println("Esecuzione Terminata");
				entraNelCiclo = false;
			} else if (scelta.equalsIgnoreCase("Acquista") || scelta.equalsIgnoreCase("Aggiungi") ||
					   scelta.equalsIgnoreCase("Visualizza") || scelta.equalsIgnoreCase("Cerca")) {
				sceltaCommerce(scelta, cliente, dannyStore);
				System.out.println("\n");
			} else {
				System.out.println("Scelta non valida. Digitare i parametri corretti");
			}
		}
		
	}
	
	public static void sceltaCommerce(String scelta, Cliente cliente, DannyStore dannyStore) {
		if (scelta.equalsIgnoreCase("Acquista")) {
			System.out.println("Sto effettuando l'acquisto del carrello\n");
			dannyStore.acquistaCarrello(cliente);
		} else if (scelta.equalsIgnoreCase("Aggiungi")) {
			System.out.println("Ok! Aggiungiamo qualcos'altro nel carrello\nInserisci l'id di un altro prodotto");
			@SuppressWarnings("resource")
			Scanner scannerAcquisto = new Scanner(System.in);
			long idAcquisto = scannerAcquisto.nextLong();
			dannyStore.aggiungiNelCarrello(idAcquisto, cliente);
		} else if (scelta.equalsIgnoreCase("Visualizza")) {
			System.out.println("Carrello del Cliente Numero " + cliente.getIdCliente());
			dannyStore.visualizzaCarrello(cliente);
		} else if (scelta.equalsIgnoreCase("Cerca")) {
			System.out.println("\nChe tipologia di articolo vuoi cercare?");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String prodottoSearch = scanner.next();
			dannyStore.cercaProdotto(prodottoSearch);
		}
	}

}
