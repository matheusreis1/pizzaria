package views.tables;

import models.Cliente;

/**
 *
 * @author user
 */
public class ClienteTable extends BaseTable<Cliente> {

    public ClienteTable() {
        super(new String[]{"nome", "sobrenome", "telefone"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) this.itens.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getTelefone();
            default : return null;
        }
    }

}
