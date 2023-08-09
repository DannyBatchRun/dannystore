package it.dannystore.service;

import it.dannystore.model.*;
import java.util.*;

public interface ClienteService {
	
	public List<Cliente> getClientiDisponibili();
	public Cliente getCliente (long idCliente);
	public Cliente creaCliente (String nome, String congome, String indirizzo);
	public long savePersistCliente (Cliente cliente);
	public void getClienteFromPersistentData (long idCliente);
	public void aggiungiCliente (Cliente cliente);
	public void aggiungiNelCarrello (long idProdotto, Cliente cliente);
	public void visualizzaCarrello (Cliente cliente);
	public void acquistaCarrello (Cliente cliente);
	
}
