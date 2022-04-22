package models;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author user
 */
class Pedido {

    private ArrayList<Pizza> pizzas;
    private StatusPedido status;
    private String identificador;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.identificador = UUID.randomUUID().toString();
    }

    public double getPreco() {
        double preco = 0;

        for (Pizza pizza : pizzas) {
            preco += pizza.getPreco();
        }

        return preco;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
