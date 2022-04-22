package models;

import enums.TipoPizza;
import errors.MaximumFlavorSize;
import java.util.ArrayList;

/**
 *
 * @author user
 */
class Pizza {

    private static final int MAXIMUM_SABOR_SIZE = 2;
    private Forma forma;
    private ArrayList<Sabor> sabores;
    private double area;

    public Pizza(Forma forma, ArrayList<Sabor> sabores, double area) throws MaximumFlavorSize {
        this.forma = forma;
        this.setSabores(sabores);
        this.area = area;
    }

    public void addSabor(Sabor sabor) throws MaximumFlavorSize {
        if (this.sabores.size() == Pizza.MAXIMUM_SABOR_SIZE) {
            throw new MaximumFlavorSize(Pizza.MAXIMUM_SABOR_SIZE);
        }
        this.sabores.add(sabor);
    }

    private void setSabores(ArrayList<Sabor> sabores) throws MaximumFlavorSize {
        for (Sabor sabor : sabores) {
            this.addSabor(sabor);
        }
    }

    public double getPreco() {
        double preco = 0;
        if (this.sabores.isEmpty()) {
            return preco;
        }
        double quantidadeSaboresDiferentes = 1;
        TipoPizza saborAntigo = this.sabores.get(0).getTipo();
        for (Sabor sabor : sabores) {
            if (!saborAntigo.equals(sabor.getTipo())) {
                quantidadeSaboresDiferentes++;
            }
            preco += sabor.getPreco();
        }
        double precoTotal = preco / quantidadeSaboresDiferentes;
        return precoTotal;
    }

}
