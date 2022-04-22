package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class Sabor {

    protected final double preco;
    protected final String nome;
    protected final ArrayList<String> ingredientes;
    protected final String tipo;

    public Sabor(double preco, String nome, ArrayList<String> ingredientes, String tipo) {
        this.preco = preco;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getTipo() {
        return this.tipo;
    }

}
