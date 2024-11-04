package br.com.motta.leiloestdsat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.annotation.processing.Generated;

@Entity(name = "produtos")
public class ProdutosDTO {

    @Id

    private int id;
    private String nome;
    private int valor;
    private String status;

    public ProdutosDTO() {
    }

    public ProdutosDTO(int id, String nome, int valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome(String text) {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
