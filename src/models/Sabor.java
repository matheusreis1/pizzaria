package models;

import enums.TipoPizza;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class Sabor {

    private double preco;
    private final String nome;
    private final ArrayList<String> ingredientes;
    private final TipoPizza tipo;

    public Sabor(double preco, String nome, ArrayList<String> ingredientes, TipoPizza tipo) {
        this.preco = preco;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }

    public TipoPizza getTipo() {
        return this.tipo;
    }

}
