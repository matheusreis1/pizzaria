package models;

import enums.StatusPedido;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Cliente {

    private String nome;
    private String sobrenome;
    private String telefone;
    private ArrayList<Pedido> pedidos;

    public Cliente() {
        this.pedidos = new ArrayList<>();
    }

    public Pedido getPedidoAtivo() {
        Pedido pedidoAtivo = null;
        if (this.pedidos.isEmpty()) {
            return pedidoAtivo;
        }

        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == StatusPedido.ABERTO) {
                pedidoAtivo = pedido;
            }
        }

        return pedidoAtivo;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

}
