package br.com.tonsoft.modelagemwebservice.repository;

import br.com.tonsoft.modelagemwebservice.model.ItemPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long> {
    public ItemPedido findById(long id);
}
