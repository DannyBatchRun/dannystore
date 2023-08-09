package it.dannystore;

import it.dannystore.service.*;

public class BeanFactory {
	
	private static ClienteService cliente = new ClienteService();
	private static ProdottoService prodotto = new ProdottoService();
	
	public static ClienteService getCliente() {
		return cliente;
	}
	
	public static ProdottoService getProdotto() {
		return prodotto;
	}
}
