package views.tables;

import models.Cliente;
import models.Pedido;

/**
 *
 * @author mathe
 */
public class PedidoTable extends BaseTable<Pedido> {

    public PedidoTable() {
        super(new String[]{"cliente", "valor", "status"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = (Pedido) this.itens.get(rowIndex);
        Cliente cliente = pedido.getCliente();
        switch (columnIndex) {
            case 0:
                return cliente.getNome() + " " + cliente.getSobrenome();
            case 1:
                return pedido.getPreco() + "";
            case 2:
                return pedido.getStatus();
            default:
                return null;
        }
    }

}
