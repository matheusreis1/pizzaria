package pizzaria;

import errors.InvalidSizeInput;
import errors.MaximumFlavorSize;
import java.util.ArrayList;
import models.Cliente;
import models.Pedido;
import models.Pizza;
import models.formas.Forma;
import models.formas.Quadrado;
import models.sabores.Sabor;
import models.tipos.Premium;
import models.tipos.TipoPizza;

/**
 *
 * @author user
 */
public class Pizzaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Sabor> sabores = new ArrayList<>();
        ArrayList<TipoPizza> tipos = new ArrayList<>();

        /* -- adicionar sabor -- */
        TipoPizza premium = new Premium();
        tipos.add(premium);
        Sabor sabor1 = new Sabor("Calabresa", "calabresa", premium);
        sabores.add(sabor1);

        /* -- adicionar cliente */
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Matheus");
        cliente1.setSobrenome("Reis");
        cliente1.setTelefone("999363337");
        clientes.add(cliente1);

        /* -- fazer pedido novo -- */
        try {
            Pedido pedido = cliente1.getPedidoAtivo();
            if (pedido == null) {
                pedido = new Pedido(cliente1);
            }
            Pizza pizza = new Pizza();
            // usuario escolhe forma e dimensao (nome depende da forma)
            double dimensao = 25.0;
            Forma forma = new Quadrado(dimensao);
            pizza.setForma(forma);

            // usuario escolhe os sabores
            pizza.addSabor(sabor1);

            pedido.addPizza(pizza);
            cliente1.addPedido(pedido);

            System.out.println("Preco do pedido: " + pedido.getPreco());
        } catch (InvalidSizeInput | MaximumFlavorSize exception) {
            System.out.println(exception.getMessage());
        }

        try {
            Pedido pedido = cliente1.getPedidoAtivo();
            if (pedido == null) {
                pedido = new Pedido(cliente1);
            }
            Pizza pizza = new Pizza();
            // usuario escolhe forma e dimensao (nome depende da forma)
            double dimensao = 25.0;
            Forma forma = new Quadrado(dimensao);
            pizza.setForma(forma);

            // usuario escolhe os sabores
            pizza.addSabor(sabor1);

            pedido.addPizza(pizza);
            cliente1.addPedido(pedido);

            System.out.println("Preco do pedido: " + pedido.getPreco());
        } catch (InvalidSizeInput | MaximumFlavorSize exception) {
            System.out.println(exception.getMessage());
        }

        /* -- pegar pedidos do cliente -- */
        for (Cliente cliente : clientes) {
            System.out.println("cliente " + cliente.getSobrenome() + "\nPedidos:");
            for (Pedido pedido : cliente.getPedidos()) {
                System.out.println("Pedido: #" + pedido.getStatus());
            }
        }
    }

}
