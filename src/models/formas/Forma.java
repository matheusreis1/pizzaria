package models.formas;

import enums.FormaPizza;

/**
 *
 * @author user
 */
public abstract class Forma {

    private FormaPizza nome;

    public Forma(FormaPizza nome) {
        this.nome = nome;
    }

    public FormaPizza getNome() {
        return this.nome;
    }

    public abstract double area();

    public abstract double getDimensao();

}
