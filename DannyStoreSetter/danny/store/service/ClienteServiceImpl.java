package danny.store.service;

import java.util.*;

import danny.store.entity.*;

public class ClienteServiceImpl implements ClienteService {
	
	private List<Cliente> clientiTotali = new ArrayList<>();
	
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
	public void creaCliente(long idCliente, String nome, String cognome, String indirizzo) {
		Cliente cliente = new Cliente(idCliente, nome, cognome, indirizzo);
		aggiungiCliente(cliente);
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
	
	private boolean controllaCampiCliente(Cliente cliente) {
		boolean riempito = false;
		if (cliente.getIdCliente() != 0 || cliente.getNome() != null ||
			cliente.getCognome() != null || cliente.getIndirizzo() != null) {
			riempito = true;
		}
		return riempito;
	}

}
