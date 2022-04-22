package models.sabores;

import enums.TipoPizza;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Simples extends Sabor {

    private static final double PRECO = 30.0;

    public Simples(String nome, ArrayList<String> ingredientes) {
        super(PRECO, nome, ingredientes, TipoPizza.SIMPLES);
    }

}
