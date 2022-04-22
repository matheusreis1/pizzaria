package models;

import enums.TipoPizza;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Especial extends Sabor {

    private static final double PRECO = 40.0;

    public Especial(String nome, ArrayList<String> ingredientes) {
        super(PRECO, nome, ingredientes, TipoPizza.ESPECIAL);
    }

}
