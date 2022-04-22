package models;

import enums.TipoPizza;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Premium extends Sabor {

    private static final double PRECO = 50.0;

    public Premium(String nome, ArrayList<String> ingredientes) {
        super(PRECO, nome, ingredientes, TipoPizza.PREMIUM);
    }

}
