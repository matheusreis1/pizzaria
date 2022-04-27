package views.tables;

import models.sabores.Sabor;

/**
 *
 * @author user
 */
public class SaboresTable extends BaseTable<Sabor> {

    public SaboresTable() {
        super(new String[]{"nome", "tipo"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sabor sabor = (Sabor) this.itens.get(rowIndex);
        switch (columnIndex) {
            case 0: return sabor.getNome();
            case 1: return sabor.getTipo().getNome();
            default : return null;
        }
    }

}
