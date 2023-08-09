package it.dannystore;

import org.springframework.context.annotation.Bean;
import it.dannystore.service.*;

public class DannyStoreConfig {
	
	@Bean(name = "prodottoAnnotation")
	public ProdottoService getProdottoService() {
		return new ProdottoService();
	}
	
	@Bean(name = "clienteAnnotation")
	public ClienteService getClienteService() {
		return new ClienteService();
	}
}
