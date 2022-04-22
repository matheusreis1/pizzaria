package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Premium extends Sabor {

    private static final double PRECO = 50.0;
    private static final String TIPO = "premium";

    public Premium(String nome, ArrayList<String> ingredientes) {
        super(PRECO, nome, ingredientes, TIPO);
    }

}
