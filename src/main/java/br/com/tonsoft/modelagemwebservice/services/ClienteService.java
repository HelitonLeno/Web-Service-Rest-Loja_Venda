package br.com.tonsoft.modelagemwebservice.services;

import br.com.tonsoft.modelagemwebservice.error.ObjectNotFoundException;
import br.com.tonsoft.modelagemwebservice.model.Cliente;
import br.com.tonsoft.modelagemwebservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(long id) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente == null) {
            throw new ObjectNotFoundException("Cliente: " + id
                    + " não encontrado. Causa: " + Cliente.class.getName());
        }

        return cliente;
    }
}
