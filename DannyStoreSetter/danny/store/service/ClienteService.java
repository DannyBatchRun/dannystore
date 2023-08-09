package danny.store.service;

import java.util.List;

import danny.store.entity.*;

public interface ClienteService {
	
	public void creaCliente(long idCliente, String nome, String cognome, String indirizzo);
	public void aggiungiCliente(Cliente cliente);
	public Cliente getCliente(long idCliente);
	public List<Cliente> getClientiDisponibili();

}
