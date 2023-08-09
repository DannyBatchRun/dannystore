package it.dannystore;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.dannystore.entity.*;
import it.dannystore.service.*;

@SuppressWarnings("resource")
public class TestApp {

	public static void main(String[] args) {
		
		ProdottoService dannyStoreProdotto = xmlConfigFactoryIstanzaProdotto();
		ClienteService dannyStoreCliente = xmlConfigFactoryIstanzaCliente();
		
		System.out.println("Benvenuti nel nostro DannyStore! Stiamo caricando tutti i prodotti disponibili.");
		long idProdotto = 3304055;
		String nome = "TV Samser";
		String tipologia = "Televisore";
		int quantita = 345;
		double prezzo = 500.0;
		
		dannyStoreProdotto.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);
		
		idProdotto = 30405060;
		nome = "Samser Galaxier V22 Mega";
		tipologia = "Smartphone";
		quantita = 3456;
		prezzo = 1000.0;
		
		dannyStoreProdotto.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);
		
		idProdotto = 3495966;
		nome = "Tobisha";
		tipologia = "Televisore";
		quantita = 222;
		prezzo = 345;
		
		dannyStoreProdotto.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);

		List<Prodotto> prodotti = dannyStoreProdotto.getProdottiDisponibili();
		
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
		
		dannyStoreCliente.creaCliente(idCliente, nomeCliente, cognomeCliente, indirizzoCliente);
		
		System.out.println("\nOra che ti sei registrato, puoi procedere.");
		Cliente cliente = dannyStoreCliente.getCliente(idCliente);
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
				sceltaCommerce(scelta, cliente, dannyStoreProdotto);
				System.out.println("\n");
			} else {
				System.out.println("Scelta non valida. Digitare i parametri corretti");
			}
		}
		
	}
	
	public static void sceltaCommerce(String scelta, Cliente cliente, ProdottoService dannyStoreProdotto) {
		if (scelta.equalsIgnoreCase("Acquista")) {
			System.out.println("Sto effettuando l'acquisto del carrello\n");
			dannyStoreProdotto.acquistaCarrello(cliente);
		} else if (scelta.equalsIgnoreCase("Aggiungi")) {
			System.out.println("Ok! Aggiungiamo qualcos'altro nel carrello\nInserisci l'id di un altro prodotto");
			Scanner scannerAcquisto = new Scanner(System.in);
			long idAcquisto = scannerAcquisto.nextLong();
			dannyStoreProdotto.aggiungiNelCarrello(idAcquisto, cliente);
		} else if (scelta.equalsIgnoreCase("Visualizza")) {
			System.out.println("Carrello del Cliente Numero " + cliente.getIdCliente());
			dannyStoreProdotto.visualizzaCarrello(cliente);
		} else if (scelta.equalsIgnoreCase("Cerca")) {
			System.out.println("\nChe tipologia di articolo vuoi cercare?");
			Scanner scanner = new Scanner(System.in);
			String prodottoSearch = scanner.next();
			dannyStoreProdotto.cercaProdotto(prodottoSearch);
		}
	}

	public static ProdottoService xmlConfigFactoryIstanzaProdotto() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-factory-istanza.xml");
		ProdottoService dannyStoreProdotto = context.getBean("prodotto", ProdottoService.class);
		return dannyStoreProdotto;
	}
	
	public static ClienteService xmlConfigFactoryIstanzaCliente() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-factory-istanza.xml");
		ClienteService dannyStoreCliente = context.getBean("cliente", ClienteService.class);
		return dannyStoreCliente;
	}
	
}
