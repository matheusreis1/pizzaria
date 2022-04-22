package models;

/**
 *
 * @author user
 */
public abstract class Forma {

    private String nome;

    public Forma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public abstract double area();

}
