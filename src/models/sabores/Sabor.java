package models.sabores;

import models.tipos.TipoPizza;

/**
 *
 * @author user
 */
public class Sabor {

    private String nome;
    private TipoPizza tipo;

    public Sabor(String nome, TipoPizza tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(TipoPizza tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public TipoPizza getTipo() {
        return this.tipo;
    }

}
