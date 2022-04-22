package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Especial extends Sabor {

    private static final double PRECO = 40.0;
    private static final String TIPO = "especial";

    public Especial(String nome, ArrayList<String> ingredientes) {
        super(PRECO, nome, ingredientes, TIPO);
    }

}
