package controller;

import model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaRequestBody {


    public Categoria criarCategoria(Categoria categoria) {
        return categoria;
    }

    public Optional<Object> buscarCategoria(Integer id) {
        return null;
    }

    public List<Categoria> listarCategoria() {
        return null;
    }

    public Categoria atualizarCategoria(Categoria categoria) {
        return categoria;
    }

    public void deletarCategoria(Integer id) {
    }

}
