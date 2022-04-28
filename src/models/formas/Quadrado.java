package models.formas;

import enums.FormaPizza;
import errors.InvalidSizeInput;

/**
 *
 * @author user
 */
public class Quadrado extends Forma {

    private static final double MINIMUM_SIZE = 10;
    private static final double MAXIMUM_SIZE = 40;
    private double lado;

    public Quadrado() {
        super(FormaPizza.QUADRADO);
    }

    public Quadrado(double lado) throws InvalidSizeInput {
        super(FormaPizza.QUADRADO);
        this.setLado(lado);
    }

    @Override
    public double area() {
        return this.lado * 2;
    }

    @Override
    public double getDimensao() {
        return this.lado;
    }

    public void setLado(double lado) throws InvalidSizeInput {
        if (lado < MINIMUM_SIZE || lado > MAXIMUM_SIZE) {
            throw new InvalidSizeInput(FormaPizza.QUADRADO.toString().toLowerCase(), MINIMUM_SIZE, MAXIMUM_SIZE);
        }
        this.lado = lado;
    }

}
