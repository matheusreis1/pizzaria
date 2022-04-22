package models;

import java.util.List;

/**
 *
 * @author user
 */
class Pizza {

    private final Forma forma;
    private final List<Sabor> sabores;
    private final double preco;
    private final double area;

    public Pizza(Forma forma, List<Sabor> sabores, double preco, double area) {
        this.forma = forma;
        this.sabores = sabores;
        this.preco = preco;
        this.area = area;
    }

    public double getPreco() {
        return 0.0;
    }

}
