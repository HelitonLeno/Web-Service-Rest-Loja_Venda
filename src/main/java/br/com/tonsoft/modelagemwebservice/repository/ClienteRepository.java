package br.com.tonsoft.modelagemwebservice.repository;

import br.com.tonsoft.modelagemwebservice.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public Cliente findById(long id);
}
