package views.combobox;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author user
 */
public class BaseComboBoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {

    private List<T> itens;
    private T itemSelecionado;
    private final static int FIRST = 0;

    public BaseComboBoxModel() {
        this.itens = new ArrayList<>();
    }

    public BaseComboBoxModel(List<T> itens) {
        this();
        this.itens = itens;
        if (getSize() > 0) {
            setSelectedItem(this.itens.get(FIRST));
        }
    }

    @Override
    public T getElementAt(int index) {
        return this.itens.get(index);
    }

    @Override
    public int getSize() {
        return this.itens.size();
    }

    @Override
    public Object getSelectedItem() {
        return itemSelecionado;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        itemSelecionado = (T) anItem;
    }

    public void adicionar(T item) {
        this.itens.add(item);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public void remover(T item) {
        int index = this.itens.indexOf(item);
        this.itens.remove(index);
        fireIntervalRemoved(this, FIRST, getSize());
    }

    public void atualizar(List<T> itens) {
        this.itens = new ArrayList<>();
        this.itens.addAll(itens);
        fireContentsChanged(this, FIRST, getSize() - 1);
    }

}
