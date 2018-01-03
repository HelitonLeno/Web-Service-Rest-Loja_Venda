package br.com.tonsoft.modelagemwebservice.endpoint;

import br.com.tonsoft.modelagemwebservice.model.Categoria;
import br.com.tonsoft.modelagemwebservice.model.Cliente;
import br.com.tonsoft.modelagemwebservice.model.Pedido;
import br.com.tonsoft.modelagemwebservice.services.CategoriaService;
import br.com.tonsoft.modelagemwebservice.services.ClienteService;
import br.com.tonsoft.modelagemwebservice.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPointController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/categoria/{id}")
    public Categoria findCategory(@PathVariable("id") long id) {
        return categoriaService.buscar(id);
    }

    @RequestMapping("/cliente/{id}")
    public Cliente findCliente(@PathVariable("id") long id) {
        return clienteService.buscar(id);
    }

    @RequestMapping("/pedido/{id}")
    public Pedido findPedido(@PathVariable("id") long id) {
        return pedidoService.buscar(id);
    }
}
