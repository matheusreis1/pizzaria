package models.tipos;

import errors.NegativeValue;

/**
 *
 * @author user
 */
public abstract class TipoPizza {

    private String nome;
    private double preco;

    public TipoPizza(String nome, double preco) throws NegativeValue {
        this.nome = nome;
        this.setPreco(preco);
    }

    public void setPreco(double preco) throws NegativeValue {
        if (preco < 0) {
            throw new NegativeValue();
        }
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

}
