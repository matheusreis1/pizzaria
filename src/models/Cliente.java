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
        if (getPedidoAtivo() == null) {
            this.pedidos.add(pedido);
        }
    }

}
