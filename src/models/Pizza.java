package models;

import errors.MaximumFlavorSize;
import java.util.ArrayList;
import models.formas.Forma;
import models.sabores.Sabor;
import models.tipos.TipoPizza;

/**
 *
 * @author user
 */
public class Pizza {

    private static final int MAXIMUM_SABOR_SIZE = 2;
    private Forma forma;
    private ArrayList<Sabor> sabores;

    public Pizza() {
        this.sabores = new ArrayList<>();
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public void addSabor(Sabor sabor) throws MaximumFlavorSize {
        if (this.sabores.size() == Pizza.MAXIMUM_SABOR_SIZE) {
            throw new MaximumFlavorSize(Pizza.MAXIMUM_SABOR_SIZE);
        }
        this.sabores.add(sabor);
    }

    public ArrayList<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(ArrayList<Sabor> sabores) throws MaximumFlavorSize {
        if (sabores.isEmpty()) {
            this.sabores = new ArrayList<>();
        } else {
            for (Sabor sabor : sabores) {
                this.addSabor(sabor);
            }
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
            preco += sabor.getTipo().getPreco();
        }
        double precoTotal = preco / quantidadeSaboresDiferentes;
        return precoTotal;
    }

    public Forma getForma() {
        return forma;
    }

    @Override
    public String toString() {
        String saboresString = "";
        for (Sabor sabor : this.sabores) {
            saboresString += sabor.getNome().toLowerCase() + ";";
        }
        return saboresString + this.forma.getNome().toString().toLowerCase();
    }

}
