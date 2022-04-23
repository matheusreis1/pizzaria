package models.sabores;

import models.tipos.TipoPizza;

/**
 *
 * @author user
 */
public class Sabor {

    private String nome;
    private String ingredientes;
    private TipoPizza tipo;

    public Sabor(String nome, String ingredientes, TipoPizza tipo) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
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
