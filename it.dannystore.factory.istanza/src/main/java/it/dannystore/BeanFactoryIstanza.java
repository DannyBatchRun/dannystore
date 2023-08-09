package it.dannystore;

import it.dannystore.service.*;

public class BeanFactoryIstanza {
	
	private ClienteService cliente = new ClienteService();
	private ProdottoService prodotto = new ProdottoService();
	
	public ClienteService getCliente() {
		return cliente;
	}
	
	public ProdottoService getProdotto() {
		return prodotto;
	}
}
