package controller;

import model.Servico;

import java.util.List;
import java.util.Optional;

public class ServicoRequestBody {
    public Servico criarServico(Servico servico) {
        return servico;
    }

    public Optional<Object> buscarServico(Integer id) {
        return null;
    }

    public List<Servico> listarServico() {
        return null;
    }

    public Servico atualizarServico(Servico servico) {
        return null;
    }

    public void deletarServico(Integer id) {
    }
}
