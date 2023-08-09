package it.dannystore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;

import it.dannystore.service.*;

@Configuration
//@Import({ ProdottoService.class, ClienteService.class })

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
