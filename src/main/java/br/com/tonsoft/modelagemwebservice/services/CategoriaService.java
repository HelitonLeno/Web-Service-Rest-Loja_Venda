package br.com.tonsoft.modelagemwebservice.services;

import br.com.tonsoft.modelagemwebservice.error.ObjectNotFoundException;
import br.com.tonsoft.modelagemwebservice.model.Categoria;
import br.com.tonsoft.modelagemwebservice.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria buscar(long id) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria == null) {
            throw new ObjectNotFoundException("Categoria: " + id
                    + " não encontrada. Causa: " + Categoria.class.getName());
        }

        return categoria;
    }

}
