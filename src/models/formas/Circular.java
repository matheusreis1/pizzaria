package models.formas;

import enums.FormaPizza;
import errors.InvalidSizeInput;

/**
 *
 * @author user
 */
public class Circular extends Forma {

    private static final double MINIMUM_SIZE = 7;
    private static final double MAXIMUM_SIZE = 23;
    private double raio;

    public Circular() {
        super(FormaPizza.CIRCULAR);
    }

    public Circular(double raio) throws InvalidSizeInput {
        super(FormaPizza.CIRCULAR);
        this.setRaio(raio);
    }

    @Override
    public double area() {
        return this.raio * Math.PI;
    }

    @Override
    public double getDimensao() {
        return this.raio;
    }

    public void setRaio(double raio) throws InvalidSizeInput {
        if (raio < MINIMUM_SIZE || raio > MAXIMUM_SIZE) {
            throw new InvalidSizeInput(FormaPizza.CIRCULAR.toString().toLowerCase(), MINIMUM_SIZE, MAXIMUM_SIZE);
        }
        this.raio = raio;
    }

}
