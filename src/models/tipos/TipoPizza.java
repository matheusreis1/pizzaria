package models.tipos;

/**
 *
 * @author user
 */
public abstract class TipoPizza {

    private String nome;
    private double preco;

    public TipoPizza(String nome, double preco) {
        this.nome = nome;
        this.setPreco(preco);
    }

    public void setPreco(double preco) {
        // validar preco negativo
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

}
