package br.com.tonsoft.modelagemwebservice.repository;

import br.com.tonsoft.modelagemwebservice.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    public Pedido findById(long id);
}
