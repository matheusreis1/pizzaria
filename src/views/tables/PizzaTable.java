package views.tables;

import models.Pizza;
import models.sabores.Sabor;

/**
 *
 * @author user
 */
public class PizzaTable extends BaseTable<Pizza> {

    public PizzaTable() {
        super(new String[]{"forma", "area", "sabores"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pizza pizza = (Pizza) this.itens.get(rowIndex);

        String saboresString = "";
        for (Sabor sabor : pizza.getSabores()) {
            saboresString += sabor.getNome().toLowerCase() + ";";
        }
        switch (columnIndex) {
            case 0:
                return pizza.getForma().getNome();
            case 1:
                return pizza.getForma().area();
            case 2:
                return saboresString.substring(0, saboresString.length() - 1);
            default:
                return null;
        }
    }

}
