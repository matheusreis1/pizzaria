package views.combobox;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import models.formas.Forma;

/**
 *
 * @author mathe
 */
public class FormaComboBoxRenderer extends DefaultListCellRenderer {

    /**
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return
     */
    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        if (value instanceof Forma) {
            value = ((Forma) value).getNome();
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
}
