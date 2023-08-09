package it.dannystore;

import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import it.dannystore.model.*;
import it.dannystore.service.*;

@SpringBootApplication
@Import(DannyStoreConfig.class)
@SuppressWarnings("resource")

public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProdottoService dannyStoreProdotto = annotationConfigProdotto(context);
		ClienteService dannyStoreCliente = annotationConfigCliente(context);

		System.out.println("Benvenuti nel nostro DannyStore! Stiamo caricando tutti i prodotti disponibili.");
		String nome = "TV Samser";
		String tipologia = "Televisore";
		int quantita = 345;
		double prezzo = 500.0;
		
		dannyStoreProdotto.creaProdotto(nome, tipologia, quantita, prezzo);

		nome = "Samser Galaxier V22 Mega";
		tipologia = "Smartphone";
		quantita = 3456;
		prezzo = 1000.0;
		
		dannyStoreProdotto.creaProdotto(nome, tipologia, quantita, prezzo);
		
		nome = "Tobisha";
		tipologia = "Televisore";
		quantita = 222;
		prezzo = 345;
		
		dannyStoreProdotto.creaProdotto(nome, tipologia, quantita, prezzo);

		List<Prodotto> prodotti = dannyStoreProdotto.getProdottiDisponibili();
		
		System.out.println("\nAl momento abbiamo questi prodotti : \n");
		for (Prodotto p : prodotti) {
			System.out.println(p);
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nRegistrati per effettuare Acquisti. Inserisci i tuoi dati personali.\nInserisci il nome");
		String nomeCliente = scanner.next();
		System.out.println("\nInserisci il cognome");
		Scanner scanner2 = new Scanner(System.in);
		String cognomeCliente = scanner2.next();
		System.out.println("\nE infine, inserisci l'indriizzo");
		Scanner scanner3 = new Scanner(System.in);
		String indirizzoCliente = scanner3.nextLine();
		System.out.println("\nPerfetto! Adesso effettuo la registrazione.");
		Cliente cliente = dannyStoreCliente.creaCliente(nomeCliente, cognomeCliente, indirizzoCliente);
		
		System.out.println("\nOra che ti sei registrato, puoi procedere.");
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
				sceltaCommerce(scelta, cliente, dannyStoreProdotto, dannyStoreCliente);
				System.out.println("\n");
			} else {
				System.out.println("Scelta non valida. Digitare i parametri corretti");
			}
		}
	}
	
	@PostConstruct
	public void initialization() {
		System.out.println("Inizializzazione del Sistema");
	}
	
	@PreDestroy
	public void closedProgram() {
		System.out.println("Chiusura del Sistema");
	}
	
	public static ProdottoService annotationConfigProdotto(ConfigurableApplicationContext context) {
		ProdottoService dannyStoreProdotto = context.getBean("prodottoAnnotation", ProdottoService.class);
		return dannyStoreProdotto;
	}
	
	public static ClienteService annotationConfigCliente(ConfigurableApplicationContext context) {
		ClienteService dannyStoreCliente = context.getBean("clienteAnnotation", ClienteService.class);
		return dannyStoreCliente;
	}
	
	public static void sceltaCommerce(String scelta, Cliente cliente, ProdottoService dannyStoreProdotto, ClienteService dannyStoreCliente) {
		if (scelta.equalsIgnoreCase("Acquista")) {
			System.out.println("Sto effettuando l'acquisto");
			dannyStoreCliente.acquistaCarrello(cliente);
		} else if (scelta.equalsIgnoreCase("Aggiungi")) {
			System.out.println("Ok! Aggiungiamo qualcos'altro nel carrello\nInserisci l'id di un altro prodotto");
			Scanner scannerAcquisto = new Scanner(System.in);
			long idAcquisto = scannerAcquisto.nextLong();
			dannyStoreCliente.aggiungiNelCarrello(idAcquisto, cliente);
		} else if (scelta.equalsIgnoreCase("Visualizza")) {
			System.out.println("Carrello del Cliente Numero " + cliente.getIdCliente());
			dannyStoreCliente.visualizzaCarrello(cliente);
		} else if (scelta.equalsIgnoreCase("Cerca")) {
			System.out.println("\nChe tipologia di articolo vuoi cercare?");
			Scanner scanner = new Scanner(System.in);
			String prodottoSearch = scanner.next();
			dannyStoreProdotto.cercaProdotto(prodottoSearch);
		}
	}

}
