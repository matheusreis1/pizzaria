package models;

import errors.InvalidSizeInput;

/**
 *
 * @author user
 */
public class Quadrado extends Forma {

    private static final double MINIMUM_SIZE = 20;
    private static final double MAXIMUM_SIZE = 60;
    private double lado;

    public Quadrado(double lado) throws InvalidSizeInput {
        super("quadrado");
        this.setLado(lado);
    }

    @Override
    public double area() {
        return this.lado * 2;
    }

    public void setLado(double lado) throws InvalidSizeInput {
        if (lado < MINIMUM_SIZE || lado > MAXIMUM_SIZE) {
            throw new InvalidSizeInput("quadrado", MINIMUM_SIZE, MAXIMUM_SIZE);
        }
        this.lado = lado;
    }

}
