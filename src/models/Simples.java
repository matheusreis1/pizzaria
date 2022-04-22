package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Simples extends Sabor {

    private static final double PRECO = 30.0;
    private static final String TIPO = "simples";

    public Simples(String nome, ArrayList<String> ingredientes) {
        super(PRECO, nome, ingredientes, TIPO);
    }

}
