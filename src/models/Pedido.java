package models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
class Pedido {

    private double preco;
    private ArrayList<Pizza> pizzas;
    private StatusPedido status;
    private String identificador;
    private Cliente cliente;

    public Pedido(double preco, ArrayList<Pizza> pizzas, StatusPedido status, String identificador, Cliente cliente) {
        this.preco = preco;
        this.pizzas = pizzas;
        this.status = status;
        this.identificador = identificador;
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

}
