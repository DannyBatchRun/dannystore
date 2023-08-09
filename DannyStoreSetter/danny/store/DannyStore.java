package danny.store;

import danny.store.entity.*;
import danny.store.service.*;
import java.util.*;

public class DannyStore {
	
	private ProdottoService prodottoService;
	private ClienteService clienteService;
	
	public DannyStore() {
		
	}
	
	public List<Prodotto> getProdottiDisponibili() {
		return prodottoService.getProdottiDisponibili();
	}
	
	public List<Cliente> getListaClienti() {
		return clienteService.getClientiDisponibili();
	}
	
	public void creaProdotto(long idProdotto, String nome, String tipologia, int quantita, double prezzo) {
		prodottoService.creaProdotto(idProdotto, nome, tipologia, quantita, prezzo);
	}
	
	public void creaCliente(long idCliente, String nome, String cognome, String indirizzo) {
		clienteService.creaCliente(idCliente, nome, cognome, indirizzo);
	}
	
	public void acquistaCarrello(Cliente cliente) {
		prodottoService.acquistaCarrello(cliente);
	}
	
	public void visualizzaCarrello(Cliente cliente) {
		prodottoService.visualizzaCarrello(cliente);
	}
	
	public Cliente getCliente(long idCliente) {
		return clienteService.getCliente(idCliente);
	}
	
	public void cercaProdotto(String nome) {
		prodottoService.cercaProdotto(nome);
	}
	
	public void aggiungiNelCarrello (long idProdotto, Cliente cliente) {
		prodottoService.aggiungiNelCarrello(idProdotto, cliente);
	}
	
	public void setProdottoServiceImpl (ProdottoServiceImpl psi) {
		prodottoService = psi;
	}
	
	public void setClienteServiceImpl (ClienteServiceImpl csi) {
		clienteService = csi;
	}

}
