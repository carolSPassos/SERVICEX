package controller;

import model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRequestBody categoriaRequestBody;

    //criar
    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
        Categoria novaCategoria = categoriaRequestBody.criarCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }
    //buscar
    @GetMapping("/{id")
    public ResponseEntity<Object> buscarCategoria(@PathVariable Integer id){
        return categoriaRequestBody.buscarCategoria(id)
                .map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(()  -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //listar
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategoria(){
        List<Categoria> categorias = categoriaRequestBody.listarCategoria();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        if(!categoriaRequestBody.buscarCategoria(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoria.setIdCategoria(id);
        Categoria novaCategoria = categoriaRequestBody.atualizarCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.OK);
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id){
        categoriaRequestBody.deletarCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
