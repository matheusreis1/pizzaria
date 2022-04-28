package views.tables;

import models.tipos.TipoPizza;
import utils.PrecoUtil;

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
        TipoPizza tipo = (TipoPizza) this.itens.get(rowIndex);

        switch (columnIndex) {
            case 0: return tipo.getNome();
            case 1: return PrecoUtil.format(tipo.getPreco());
            default : return null;
        }
    }

}
