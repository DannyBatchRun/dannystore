package it.dannystore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.dannystore.model.*;

@Repository

public interface ClienteRepository extends CrudRepository <Cliente, Long> {

}
