package controller;

import model.Categoria;
import model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {
    @Autowired
    private ServicoRequestBody servicoRequestBody;

    //criar
    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico){
        Servico novoServico = servicoRequestBody.criarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }
    //buscar
    @GetMapping("/{id")
    public ResponseEntity<Object> buscarServico(@PathVariable Integer id){
        return servicoRequestBody.buscarServico(id)
                .map(servico -> new ResponseEntity<>(servico, HttpStatus.OK))
                .orElseGet(()  -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //listar
    @GetMapping
    public ResponseEntity<List<Servico>> listarServico(){
        List<Servico> servicos = servicoRequestBody.listarServico();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Integer id, @RequestBody Servico servico){
        if(!servicoRequestBody.buscarServico(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.setIdServico(id);
        Servico novoServico = servicoRequestBody.atualizarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.OK);
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Integer id){
        servicoRequestBody.deletarServico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
