package models.tipos;

import errors.NegativeValue;

/**
 *
 * @author user
 */
public class Premium extends TipoPizza {

    private static final double PRECO = 50.0;

    public Premium() throws NegativeValue {
        super("premium", PRECO);
    }

}
