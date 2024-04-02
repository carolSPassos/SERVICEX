package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servico")

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idServico;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private double valor;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    //private OrdemServico ordemServico;

    public Integer getIdServico() {return idServico;}

    public void setIdServico(Integer idServico) {this.idServico = idServico;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public double getValor() {return valor;}

    public void setValor(double valor) {this.valor = valor;}

    public Categoria getCategoria() {return categoria;}

    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

   /* public List<OrdemServico> getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(List<OrdemServico> ordemServico) {
        this.ordemServico = ordemServico;
    }*/
}
