package views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Cliente;

/**
 *
 * @author user
 */
public class ClienteTable extends AbstractTableModel {

    private String[] columns = new String[]{"nome", "sobrenome", "telefone"};
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.columns[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getTelefone();
            default : return null;
        }
    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
        this.fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
    }

    public boolean remover(Cliente cliente) {
        int linha = this.clientes.indexOf(cliente);
        boolean result = this.clientes.remove(cliente);
        this.fireTableRowsDeleted(linha, linha);
        return result;
    }
    
    public void atualizarTabela(List<Cliente> clientes) {
        this.clientes = new ArrayList<>();
        this.clientes.addAll(clientes);
        this.fireTableDataChanged();
    }

}
