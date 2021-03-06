package models.formas;

import enums.FormaPizza;
import errors.InvalidSizeInput;

/**
 *
 * @author user
 */
public class Triangulo extends Forma {

    private static final double MINIMUM_SIZE = 20;
    private static final double MAXIMUM_SIZE = 60;
    private double lado;

    public Triangulo() {
        super(FormaPizza.TRIANGULO);
    }

    public Triangulo(double lado) throws InvalidSizeInput {
        super(FormaPizza.TRIANGULO);
        this.setLado(lado);
    }

    @Override
    public double area() {
        return this.lado * 3;
    }

    @Override
    public double getDimensao() {
        return this.lado;
    }

    public void setLado(double lado) throws InvalidSizeInput {
        if (lado < MINIMUM_SIZE || lado > MAXIMUM_SIZE) {
            throw new InvalidSizeInput(FormaPizza.TRIANGULO.toString().toLowerCase(), MINIMUM_SIZE, MAXIMUM_SIZE);
        }
        this.lado = lado;
    }

}
