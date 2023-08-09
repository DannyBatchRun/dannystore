package it.dannystore;

import org.springframework.context.annotation.Bean;
import it.dannystore.service.*;

public class DannyStoreConfig {
	
	@Bean(name = "prodottoAnnotation", initMethod = "initProdottoService", destroyMethod = "destroyProdottoService")
	public ProdottoService getProdottoService() {
		return new ProdottoService();
	}
	
	@Bean(name = "clienteAnnotation", initMethod = "initClienteService", destroyMethod = "destroyClienteService")
	public ClienteService getClienteService() {
		return new ClienteService();
	}
	
	@Bean(name = "programma", initMethod = "initProgramming", destroyMethod = "closeProgramming") 
	public TestApp getTestApp() {
		return new TestApp();
	}

}
