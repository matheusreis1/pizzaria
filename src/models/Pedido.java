package models;

import enums.StatusPedido;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author user
 */
public class Pedido {

    private ArrayList<Pizza> pizzas;
    private StatusPedido status;
    private String identificador;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.identificador = UUID.randomUUID().toString();
        this.pizzas = new ArrayList<>();
        this.status = StatusPedido.ABERTO;
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
