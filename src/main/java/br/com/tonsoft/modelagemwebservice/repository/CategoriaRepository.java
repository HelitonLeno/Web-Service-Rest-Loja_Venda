package br.com.tonsoft.modelagemwebservice.repository;

import br.com.tonsoft.modelagemwebservice.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    public Categoria findById(long id);
}
