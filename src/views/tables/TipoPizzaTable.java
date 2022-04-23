package views.tables;

import models.tipos.TipoPizza;

/**
 *
 * @author user
 */
public class TipoPizzaTable extends BaseTable<TipoPizza> {

    public TipoPizzaTable() {
        super(new String[]{"nome", "preço"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoPizza cliente = (TipoPizza) this.itens.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getPreco();
            default : return null;
        }
    }

}
