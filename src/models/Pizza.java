package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
class Pizza {

    private final Forma forma;
    private final ArrayList<Sabor> sabores;
    private final double preco;
    private final double area;

    public Pizza(Forma forma, ArrayList<Sabor> sabores, double preco, double area) {
        this.forma = forma;
        this.sabores = sabores;
        this.preco = preco;
        this.area = area;
    }

    public double getPreco() {
        return 0.0;
    }

}
