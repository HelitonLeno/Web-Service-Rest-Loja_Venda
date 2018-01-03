package br.com.tonsoft.modelagemwebservice.services;

import br.com.tonsoft.modelagemwebservice.error.ObjectNotFoundException;
import br.com.tonsoft.modelagemwebservice.model.Pedido;
import br.com.tonsoft.modelagemwebservice.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new ObjectNotFoundException("Pedido: " + id
                    + " não encontrado. Causa: " + Pedido.class.getName());
        }
        return pedido;
    }
}
