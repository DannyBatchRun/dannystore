package it.dannystore.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dannystore.model.*;
import it.dannystore.repository.ClienteRepository;
import it.dannystore.repository.ProdottoRepository;

@Service

public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	private List<Cliente> clientiTotali = new ArrayList<>();
	
	@Override
	public List<Cliente> getClientiDisponibili() {
		return clientiTotali;
	}
	
	@Override
	public Cliente getCliente(long idCliente) {
		Cliente cliente = new Cliente();
		for (Cliente c : clientiTotali) {
			if (idCliente == c.getIdCliente()) {
				cliente = c;
			}
		}
		controllaCampiCliente(cliente);
		return cliente;
	}
	
	@Override
	public Cliente creaCliente(String nome, String cognome, String indirizzo) {
		Cliente cliente = new Cliente(nome, cognome, indirizzo);
		long idCliente = savePersistCliente(cliente);
		cliente.setIdCliente(idCliente);
		aggiungiCliente(cliente);
		return cliente;
	}
	
	@Override
	public long savePersistCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getIdCliente();
	}
	
	@Override
	public void getClienteFromPersistentData (long idCliente) {
		clienteRepository.findById(idCliente);
	}

	@Override
	public void aggiungiCliente(Cliente cliente) {
		boolean riempito = controllaCampiCliente(cliente);
		if (!riempito) {
			System.out.println("Non sono stati riempiti tutti i campi correttamente. Riprova.");
		} else if (riempito) {
			clientiTotali.add(cliente);
			System.out.println("\nRegistrazione Completata.");
			System.out.println(cliente);
		}
	}
	
	@Override
	public void aggiungiNelCarrello(long idProdotto, Cliente cliente) {
		Prodotto prodotto = prodottoRepository.findById(idProdotto);
		double totaleCarrello = cliente.getTotaleCarrello() + prodotto.getPrezzo();
		System.out.println("Articolo Aggiunto nel Carrello. Ora il tuo conto è di " + totaleCarrello + "€.");
		cliente.setTotaleCarrello(totaleCarrello);
		savePersistCliente(cliente);
	}
	
	@Override
	public void visualizzaCarrello (Cliente cliente) {
		System.out.println("Il Totale del Carrello è di Circa " + cliente.getTotaleCarrello() + "€.");
	}
	
	@Override
	public void acquistaCarrello (Cliente cliente) {
		System.out.println("Acquisto EFfettuato. Hai pagato circa " + cliente.getTotaleCarrello()
							+ "€ e i prodotti verranno spediti all'indirizzo " + cliente.getIndirizzo()
							+ ".\nGrazie e arrivederci!");
		cliente.setTotaleCarrello(0);
		savePersistCliente(cliente);
	}
	
	private boolean controllaCampiCliente(Cliente cliente) {
		boolean riempito = false;
		if (cliente.getIdCliente() != 0 || cliente.getNome() != null ||
			cliente.getCognome() != null || cliente.getIndirizzo() != null) {
			riempito = true;
		}
		return riempito;
	}

}
