package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class Sabor {

    private final double preco;
    private final String nome;
    private final ArrayList<String> ingredientes;
    private final String tipo;

    public Sabor(double preco, String nome, ArrayList<String> ingredientes, String tipo) {
        this.preco = preco;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }

    public abstract double getPreco();

    public abstract String getTipo();

}
