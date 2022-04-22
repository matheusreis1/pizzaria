package models;

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

    public Cliente(String nome, String sobrenome, String telefone, ArrayList<Pedido> pedidos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public Pedido getPedidoAtivo() {
        Pedido pedidoAtivo = null;

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

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

}
