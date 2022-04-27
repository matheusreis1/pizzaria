package models.tipos;

import errors.NegativeValue;

/**
 *
 * @author user
 */
public class Especial extends TipoPizza {

    private static final double PRECO = 40.0;

    public Especial() throws NegativeValue {
        super("especial", PRECO);
    }

}
