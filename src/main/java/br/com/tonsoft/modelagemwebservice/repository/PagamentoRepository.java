package br.com.tonsoft.modelagemwebservice.repository;

import br.com.tonsoft.modelagemwebservice.model.Pagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
    public Pagamento findById(long id);
}
