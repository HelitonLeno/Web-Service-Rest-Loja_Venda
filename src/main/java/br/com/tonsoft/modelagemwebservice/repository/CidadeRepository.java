package br.com.tonsoft.modelagemwebservice.repository;

import br.com.tonsoft.modelagemwebservice.model.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long> {
}
