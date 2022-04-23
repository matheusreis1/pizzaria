package views.tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public abstract class BaseTable<T> extends AbstractTableModel {

    private String[] colunas;
    protected List itens;

    public BaseTable(String[] colunas) {
        this.colunas = colunas;
        this.itens = new ArrayList<T>();
    }

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            default : return null;
        }
    }

    public void adicionar(T item) {
        this.itens.add(item);
        this.fireTableRowsInserted(itens.size() - 1, itens.size() - 1);
    }

    public boolean remover(T item) {
        int linha = this.itens.indexOf(item);
        boolean result = this.itens.remove(item);
        this.fireTableRowsDeleted(linha, linha);
        return result;
    }

    public void atualizarTabela(List<T> itens) {
        this.itens = new ArrayList<>();
        this.itens.addAll(itens);
        this.fireTableDataChanged();
    }

}
