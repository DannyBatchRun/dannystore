package it.dannystore.repository;

import org.springframework.data.repository.CrudRepository;

import it.dannystore.model.*;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {
	
	public Prodotto findById (long idProdotto);

}
