package views.tables;

import models.sabores.Sabor;

/**
 *
 * @author user
 */
public class SaboresTable extends BaseTable<Sabor> {

    public SaboresTable() {
        super(new String[]{"nome", "ingredientes", "tipo"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sabor cliente = (Sabor) this.itens.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getIngredientes();
            case 2: return cliente.getTipo().getNome();
            default : return null;
        }
    }

}
