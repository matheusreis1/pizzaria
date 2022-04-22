package models;

import java.util.ArrayList;
import java.util.UUID;

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

    public Pedido(Cliente cliente) {
        this.identificador = UUID.randomUUID().toString();
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
