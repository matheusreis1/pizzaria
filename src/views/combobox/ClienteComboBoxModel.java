package views.combobox;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author mathe
 */
public class ClienteComboBoxModel<Cliente> extends AbstractListModel<Cliente> implements ComboBoxModel<Cliente> {

    private List<Cliente> clientes;
    private Cliente clienteSelecionado;
    private final static int FIRST = 0;

    public ClienteComboBoxModel() {
        this.clientes = new ArrayList<>();
    }

    public ClienteComboBoxModel(List<Cliente> clientes) {
        this();
        this.clientes = clientes;
        if (getSize() > 0) {
            setSelectedItem(this.clientes.get(FIRST));
        }
    }

    @Override
    public Cliente getElementAt(int index) {
        return this.clientes.get(index);
    }

    @Override
    public int getSize() {
        return this.clientes.size();
    }

    @Override
    public Object getSelectedItem() {
        return clienteSelecionado;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        clienteSelecionado = (Cliente) anItem;
    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(this.clientes.get(getSize() - 1));
    }

    public void remover() {
        this.clientes.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRST, getSize() - 1);
        setSelectedItem(this.clientes.get(FIRST));
    }

}
