package models.tipos;

import errors.NegativeValue;

/**
 *
 * @author user
 */
public class Simples extends TipoPizza {

    private static final double PRECO = 30.0;

    public Simples() throws NegativeValue {
        super("simples", PRECO);
    }

}
