/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import enums.StatusPedido;
import errors.InvalidSizeInput;
import errors.MaximumFlavorSize;
import errors.NegativeValue;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import models.Cliente;
import models.Pedido;
import models.Pizza;
import models.formas.Circular;
import models.formas.Forma;
import models.formas.Quadrado;
import models.formas.Triangulo;
import models.sabores.Sabor;
import models.tipos.Especial;
import models.tipos.Premium;
import models.tipos.Simples;
import models.tipos.TipoPizza;
import views.combobox.BaseComboBoxModel;
import views.combobox.ClienteComboBoxRenderer;
import views.combobox.FormaComboBoxRenderer;
import views.combobox.SaboresComboBoxRenderer;
import views.tables.BaseTable;
import views.tables.ClienteTable;
import views.tables.PedidoTable;
import views.tables.PizzaTable;
import views.tables.SaboresTable;
import views.tables.TipoPizzaTable;

/**
 *
 * @author user
 */
public class Pizzaria extends javax.swing.JFrame {

    /* cliente */
    private List<Cliente> clientes;
    private int clientesLinhaSelecionada = -1;
    private BaseTable clientesTableModel = new ClienteTable();
    /* tipos de pizza */
    private List<TipoPizza> tipos;
    private int tipoLinhaSelecionada = -1;
    private BaseTable tiposTableModel = new TipoPizzaTable();
    /* sabores */
    private List<Sabor> sabores;
    private int saborLinhaSelecionada = -1;
    private BaseTable saborTableModel = new SaboresTable();
    /* pedidos */
    private List<Pedido> pedidos;
    private int pedidoLinhaSelecionada = -1;
    private BaseTable pedidoTableModel = new PedidoTable();
    private BaseComboBoxModel clienteComboBoxModel = new BaseComboBoxModel<Cliente>();
    private BaseComboBoxModel saboresComboBoxModel1 = new BaseComboBoxModel<Sabor>();
    private BaseComboBoxModel saboresComboBoxModel2 = new BaseComboBoxModel<Sabor>();
    private BaseComboBoxModel formaComboBoxModel = new BaseComboBoxModel<Forma>();
    private List<Pizza> pizzas;
    private int pizzaLinhaSelecionada = -1;
    private BaseTable pizzaTableModel = new PizzaTable();
    private DefaultComboBoxModel<StatusPedido> pedidoStatusComboBoxModel = new DefaultComboBoxModel(StatusPedido.values());

    private Pedido pedido = null;

    /* formas */
    private List<Forma> formas;

    /**
     * Creates new form Pizzaria
     */
    public Pizzaria() {
        initComponents();
        /* cliente */
        clientes = new ArrayList<>();

        /* tipos */
        TipoPizza premium = null, especial = null, simples = null;
        try {
            premium = new Premium();
            especial = new Especial();
            simples = new Simples();
        } catch (NegativeValue ex) {
            Logger.getLogger(Pizzaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        tipos = new ArrayList<>();
        tipos.add(simples);
        tipos.add(especial);
        tipos.add(premium);
        tiposTableModel.atualizarTabela(tipos);

        /* sabores */
        sabores = new ArrayList<>();
        saboresTipoComboBox.addItem(simples);
        saboresTipoComboBox.addItem(especial);
        saboresTipoComboBox.addItem(premium);

        /* pedidos */
        pedidos = new ArrayList<>();
        pizzas = new ArrayList<>();

        /* formas */
        formas = new ArrayList<>();
        Forma circular = new Circular();
        Forma quadrado = new Quadrado();
        Forma triangulo = new Triangulo();
        formas.add(circular);
        formas.add(quadrado);
        formas.add(triangulo);
        formaComboBoxModel.atualizar(formas);
    }

    private boolean isClienteFieldsEmpty() {
        return clienteNomeField.getText().isEmpty() || clienteSobreNomeField.getText().isEmpty() || clienteTelefoneField.getText().isEmpty();
    }

    private void limparClientesForm() {
        clienteNomeField.setText("");
        clienteSobreNomeField.setText("");
        clienteTelefoneField.setText("");
        clientesLinhaSelecionada = -1;
        clientesTableModel.atualizarTabela(clientes);
        clienteErrorText.setText("");
        clientePesquisarText.setText("");
    }

    private void preencherClientesForm(Cliente cliente) {
        clienteNomeField.setText(cliente.getNome());
        clienteSobreNomeField.setText(cliente.getSobrenome());
        clienteTelefoneField.setText(cliente.getTelefone());
    }

    private void limparTiposForm() {
        tipoNomeText.setText("");
        tipoPrecoText.setText("");
        tipoErroText.setText("");
    }

    private void preencherTiposForm(TipoPizza tipo) {
        tipoNomeText.setText(tipo.getNome());
        tipoPrecoText.setValue(tipo.getPreco());
    }

    private void limparSaboresForm() {
        saboresNomeText.setText("");
        saboresTipoComboBox.setSelectedIndex(-1);
        saboresTipoErroText.setText("");
    }

    private void limparPizzaErroText() {
        pedidoClienteErroText.setText("");
        pedidoFormaErroText.setText("");
        dimensaoErroText.setText("");
        pedidoSaborErroText.setText("");
    }

    private void limparPizzaForm() {
        this.limparPizzaErroText();
        dimensaoTextField.setText("");
        formaComboBoxModel.atualizar(formas);
        saboresComboBoxModel1.atualizar(sabores);
        saboresComboBoxModel2.atualizar(sabores);
        pedidoSaboresComboBox1.setSelectedIndex(-1);
        pedidoSaboresComboBox2.setSelectedIndex(-1);
        pedidoFormaComboBox.setSelectedIndex(-1);
    }

    private void limparNovoPedidoForm() {
        this.limparPizzaForm();
        this.pizzas = new ArrayList<>();
        this.pizzaTableModel.atualizarTabela(this.pizzas);
        pedidoPrecoTotal.setText("");
        clienteComboBoxModel.atualizar(this.clientes);
        pedidosClienteComboBox.setSelectedIndex(-1);
    }

    private void limparPedidoForm() {
        pedidoIdentificador.setText("");
        pedidoStatusComboBox.setSelectedIndex(-1);
    }

    private void preencherPedidoForm(Pedido pedido) {
        pedidoIdentificador.setText(pedido.getIdentificador());
        pedidoStatusComboBox.setSelectedItem(pedido.getStatus());
    }

    private void salvarPizza() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        clientesPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clienteSobreNomeField = new javax.swing.JTextField();
        clienteNomeField = new javax.swing.JTextField();
        clienteTelefoneField = new javax.swing.JTextField();
        clienteExcluirButton = new javax.swing.JButton();
        clienteAtualizarButton = new javax.swing.JButton();
        clienteCadastrarButton = new javax.swing.JButton();
        clienteErrorText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        clientePesquisarText = new javax.swing.JTextField();
        clientePesquisarButton = new javax.swing.JButton();
        clientesLimparButton = new javax.swing.JButton();
        tiposPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tipoPrecoText = new javax.swing.JFormattedTextField();
        tipoNomeText = new javax.swing.JTextField();
        tipoSalvarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tiposTable = new javax.swing.JTable();
        tipoErroText = new javax.swing.JLabel();
        saboresPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        saboresNomeText = new javax.swing.JTextField();
        saboresTipoComboBox = new javax.swing.JComboBox<>();
        saboresSalvarButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        saboresTable = new javax.swing.JTable();
        saboresTipoErroText = new javax.swing.JLabel();
        pedidosPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pizzaPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pedidoAdicionarPizzaButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pedidoFormaComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        dimensaoTextField = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        pedidoSaboresComboBox1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        pedidoSaboresComboBox2 = new javax.swing.JComboBox<>();
        dimensaoErroText = new javax.swing.JLabel();
        pedidoFormaErroText = new javax.swing.JLabel();
        pedidoSaborErroText = new javax.swing.JLabel();
        atualizarPizzaButton = new javax.swing.JButton();
        pedidoPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pedidoStatusComboBox = new javax.swing.JComboBox<>();
        atualizarPedidoButton = new javax.swing.JToggleButton();
        jLabel18 = new javax.swing.JLabel();
        pedidoIdentificador = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        pedidosClienteComboBox = new javax.swing.JComboBox<>();
        pedidoClienteErroText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pedidoPrecoTotal = new javax.swing.JFormattedTextField();
        pedidoSalvarButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pedidosTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        pizzasTable = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Sobrenome");

        jLabel3.setText("Telefone");

        clienteExcluirButton.setText("excluir");
        clienteExcluirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clienteExcluirButtonMouseReleased(evt);
            }
        });

        clienteAtualizarButton.setText("atualizar");
        clienteAtualizarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clienteAtualizarButtonMouseReleased(evt);
            }
        });

        clienteCadastrarButton.setText("cadastrar");
        clienteCadastrarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clienteCadastrarButtonMouseReleased(evt);
            }
        });

        clienteErrorText.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(clienteNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clienteSobreNomeField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(clienteTelefoneField))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clienteErrorText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 102, Short.MAX_VALUE)
                                .addComponent(clienteExcluirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteAtualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteCadastrarButton)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clienteNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteSobreNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clienteTelefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(clienteErrorText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteExcluirButton)
                    .addComponent(clienteAtualizarButton)
                    .addComponent(clienteCadastrarButton))
                .addGap(10, 10, 10))
        );

        clientesTable.setModel(clientesTableModel);
        clientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientesTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(clientesTable);

        clientePesquisarButton.setText("pesquisar");

        clientesLimparButton.setText("limpar");
        clientesLimparButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientesLimparButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(493, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(clientePesquisarText, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientePesquisarButton))
                    .addComponent(clientesLimparButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientePesquisarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientePesquisarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientesLimparButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout clientesPanelLayout = new javax.swing.GroupLayout(clientesPanel);
        clientesPanel.setLayout(clientesPanelLayout);
        clientesPanelLayout.setHorizontalGroup(
            clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(clientesPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        clientesPanelLayout.setVerticalGroup(
            clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", clientesPanel);

        jLabel8.setText("Nome");

        jLabel9.setText("Preço (cm²)");

        tipoPrecoText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        tipoNomeText.setEnabled(false);

        tipoSalvarButton.setText("salvar");
        tipoSalvarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tipoSalvarButtonMouseReleased(evt);
            }
        });

        tiposTable.setModel(tiposTableModel);
        tiposTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tiposTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tiposTable);

        tipoErroText.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout tiposPanelLayout = new javax.swing.GroupLayout(tiposPanel);
        tiposPanel.setLayout(tiposPanelLayout);
        tiposPanelLayout.setHorizontalGroup(
            tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiposPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(tiposPanelLayout.createSequentialGroup()
                        .addGroup(tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tiposPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(tiposPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)))
                        .addGroup(tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoErroText, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(tipoPrecoText)
                            .addComponent(tipoNomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(tipoSalvarButton)
                        .addGap(0, 828, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tiposPanelLayout.setVerticalGroup(
            tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiposPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tipoNomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoSalvarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tiposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tipoPrecoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoErroText)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tipos de pizza", tiposPanel);

        jLabel5.setText("Nome");

        jLabel10.setText("Tipo");

        saboresTipoComboBox.setRenderer(new TipoComboBox());

        saboresSalvarButton.setText("salvar");
        saboresSalvarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saboresSalvarButtonMouseReleased(evt);
            }
        });

        saboresTable.setModel(saborTableModel);
        jScrollPane3.setViewportView(saboresTable);

        saboresTipoErroText.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout saboresPanelLayout = new javax.swing.GroupLayout(saboresPanel);
        saboresPanel.setLayout(saboresPanelLayout);
        saboresPanelLayout.setHorizontalGroup(
            saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saboresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
                    .addGroup(saboresPanelLayout.createSequentialGroup()
                        .addGroup(saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(saboresPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(saboresNomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saboresPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(saboresTipoErroText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saboresTipoComboBox, 0, 190, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(saboresSalvarButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        saboresPanelLayout.setVerticalGroup(
            saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saboresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(saboresNomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saboresSalvarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(saboresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(saboresTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saboresTipoErroText)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sabores", saboresPanel);

        jLabel11.setText("Informações da pizza");
        jLabel11.setToolTipText("");

        pedidoAdicionarPizzaButton.setText("salvar pizza");
        pedidoAdicionarPizzaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pedidoAdicionarPizzaButtonMouseReleased(evt);
            }
        });

        jLabel6.setText("Forma");

        pedidoFormaComboBox.setModel(formaComboBoxModel);
        pedidoFormaComboBox.setRenderer(new FormaComboBoxRenderer());

        jLabel12.setText("Dimensao");

        jLabel13.setText("Sabor 1");

        pedidoSaboresComboBox1.setModel(saboresComboBoxModel1);
        pedidoSaboresComboBox1.setRenderer(new SaboresComboBoxRenderer());

        jLabel19.setText("Sabor 2");

        pedidoSaboresComboBox2.setModel(saboresComboBoxModel2);
        pedidoSaboresComboBox2.setRenderer(new SaboresComboBoxRenderer());

        dimensaoErroText.setForeground(new java.awt.Color(255, 51, 51));

        pedidoFormaErroText.setForeground(new java.awt.Color(255, 51, 51));

        pedidoSaborErroText.setForeground(new java.awt.Color(255, 0, 0));

        atualizarPizzaButton.setText("atualizar pizza");
        atualizarPizzaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                atualizarPizzaButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pizzaPanelLayout = new javax.swing.GroupLayout(pizzaPanel);
        pizzaPanel.setLayout(pizzaPanelLayout);
        pizzaPanelLayout.setHorizontalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pizzaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pizzaPanelLayout.createSequentialGroup()
                        .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pizzaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dimensaoErroText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pizzaPanelLayout.createSequentialGroup()
                                        .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pedidoFormaErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dimensaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pizzaPanelLayout.createSequentialGroup()
                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pizzaPanelLayout.createSequentialGroup()
                                        .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel13))
                                        .addGap(31, 31, 31)
                                        .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(pedidoSaboresComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(pedidoSaboresComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pizzaPanelLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(pedidoSaborErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pizzaPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)
                                        .addGap(31, 31, 31)
                                        .addComponent(pedidoFormaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pedidoAdicionarPizzaButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(atualizarPizzaButton)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(101, 101, 101))))
        );
        pizzaPanelLayout.setVerticalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pizzaPanelLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pedidoFormaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(pedidoAdicionarPizzaButton)
                    .addComponent(atualizarPizzaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pedidoFormaErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dimensaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimensaoErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(pedidoSaboresComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pedidoSaborErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(pedidoSaboresComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel16.setText("Alterar pedido");

        jLabel17.setText("Status");

        pedidoStatusComboBox.setModel(pedidoStatusComboBoxModel);

        atualizarPedidoButton.setText("atualizar pedido");
        atualizarPedidoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                atualizarPedidoButtonMouseReleased(evt);
            }
        });

        jLabel18.setText("Pedido");

        pedidoIdentificador.setEnabled(false);

        jLabel20.setText("Novo pedido");

        pedidosClienteComboBox.setModel(clienteComboBoxModel);
        pedidosClienteComboBox.setRenderer(new ClienteComboBoxRenderer());

        pedidoClienteErroText.setForeground(new java.awt.Color(255, 51, 51));

        jLabel4.setText("Cliente");

        jLabel14.setText("Preço total");

        pedidoPrecoTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        pedidoPrecoTotal.setEnabled(false);

        pedidoSalvarButton.setText("salvar novo pedido");
        pedidoSalvarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pedidoSalvarButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pedidoPanelLayout = new javax.swing.GroupLayout(pedidoPanel);
        pedidoPanel.setLayout(pedidoPanelLayout);
        pedidoPanelLayout.setHorizontalGroup(
            pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoPanelLayout.createSequentialGroup()
                        .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(pedidoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(pedidosClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pedidoSalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pedidoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pedidoClienteErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pedidoPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))))
            .addGroup(pedidoPanelLayout.createSequentialGroup()
                .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(atualizarPedidoButton)
                    .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pedidoPanelLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(pedidoStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel16)
                        .addGroup(pedidoPanelLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pedidoIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pedidoPanelLayout.setVerticalGroup(
            pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pedidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pedidosClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidoSalvarButton))
                .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pedidoPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(pedidoPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pedidoPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(pedidoClienteErroText, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(pedidoIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pedidoStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarPedidoButton)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pedidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pizzaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pedidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pizzaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel15.setText("Pedidos");

        pedidosTable.setModel(pedidoTableModel);
        pedidosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pedidosTableMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(pedidosTable);

        pizzasTable.setModel(pizzaTableModel);
        pizzasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pizzasTableMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(pizzasTable);

        jLabel21.setText("Pizzas do pedido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(254, 254, 254)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pedidosPanelLayout = new javax.swing.GroupLayout(pedidosPanel);
        pedidosPanel.setLayout(pedidosPanelLayout);
        pedidosPanelLayout.setHorizontalGroup(
            pedidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pedidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pedidosPanelLayout.setVerticalGroup(
            pedidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", pedidosPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saboresSalvarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saboresSalvarButtonMouseReleased
        if (saboresTipoComboBox.getSelectedItem() == null || saboresNomeText.getText().isEmpty()) {
            saboresTipoErroText.setText("O sabor tem que ter um tipo e um nome!");
            return;
        }

        String nome = saboresNomeText.getText();
        TipoPizza tipo = (TipoPizza) saboresTipoComboBox.getSelectedItem();

        Sabor sabor = new Sabor(nome, tipo);
        sabores.add(sabor);
        saborTableModel.adicionar(sabor);
        saboresComboBoxModel1.adicionar(sabor);
        saboresComboBoxModel2.adicionar(sabor);

        limparSaboresForm();
    }//GEN-LAST:event_saboresSalvarButtonMouseReleased

    private void tiposTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tiposTableMouseReleased
        tipoLinhaSelecionada = tiposTable.getSelectedRow();
        if (tipoLinhaSelecionada == -1) {
            return;
        }
        TipoPizza tipo = this.tipos.get(tipoLinhaSelecionada);

        preencherTiposForm(tipo);
    }//GEN-LAST:event_tiposTableMouseReleased

    private void tipoSalvarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoSalvarButtonMouseReleased
        if (tipoLinhaSelecionada == -1) {
            return;
        }
        double preco = Double.parseDouble(tipoPrecoText.getValue().toString());
        TipoPizza tipo = this.tipos.get(tipoLinhaSelecionada);

        try {
            tipo.setPreco(preco);
        } catch (NegativeValue ex) {
            tipoErroText.setText(ex.getMessage());
            return;
        }
        tiposTableModel.atualizarTabela(this.tipos);

        limparTiposForm();
    }//GEN-LAST:event_tipoSalvarButtonMouseReleased

    private void clientesLimparButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesLimparButtonMouseReleased
        limparClientesForm();
    }//GEN-LAST:event_clientesLimparButtonMouseReleased

    private void clientesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseReleased
        clientesLinhaSelecionada = clientesTable.getSelectedRow();
        if (clientesLinhaSelecionada == -1) {
            return;
        }
        Cliente cliente = this.clientes.get(clientesLinhaSelecionada);

        preencherClientesForm(cliente);
    }//GEN-LAST:event_clientesTableMouseReleased

    private void clienteCadastrarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteCadastrarButtonMouseReleased
        if (clientesLinhaSelecionada != -1) {
            return;
        }
        if (isClienteFieldsEmpty()) {
            clienteErrorText.setText("Todos os campos sao obrigatorios!");
            return;
        }
        Cliente cliente = new Cliente();
        cliente.setNome(clienteNomeField.getText());
        cliente.setSobrenome(clienteSobreNomeField.getText());
        cliente.setTelefone(clienteTelefoneField.getText());
        clientes.add(cliente);
        clientesTableModel.adicionar(cliente);
        clienteComboBoxModel.adicionar(cliente);

        limparClientesForm();
    }//GEN-LAST:event_clienteCadastrarButtonMouseReleased

    private void clienteAtualizarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteAtualizarButtonMouseReleased
        if (clientesLinhaSelecionada == -1) {
            return;
        }
        if (isClienteFieldsEmpty()) {
            clienteErrorText.setText("Todos os campos sao obrigatorios!");
            return;
        }

        Cliente cliente = this.clientes.get(clientesLinhaSelecionada);

        cliente.setNome(clienteNomeField.getText());
        cliente.setSobrenome(clienteSobreNomeField.getText());
        cliente.setTelefone(clienteTelefoneField.getText());

        clientesTableModel.atualizarTabela(this.clientes);
        clienteComboBoxModel.atualizar(this.clientes);

        limparClientesForm();
    }//GEN-LAST:event_clienteAtualizarButtonMouseReleased

    private void clienteExcluirButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteExcluirButtonMouseReleased
        if (clientesLinhaSelecionada == -1) {
            return;
        }
        Cliente cliente = this.clientes.get(clientesLinhaSelecionada);

        this.clientes.remove(cliente);

        clientesTableModel.remover(cliente);
        clientesTableModel.atualizarTabela(this.clientes);
        clienteComboBoxModel.remover(cliente);

        limparClientesForm();
    }//GEN-LAST:event_clienteExcluirButtonMouseReleased

    private void pedidoSalvarButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoSalvarButtonMouseReleased
        if (pedido == null) {
            return;
        }

        pedidos.add(pedido);
        pedidoTableModel.adicionar(pedido);

        pedido = null;

        limparNovoPedidoForm();
    }//GEN-LAST:event_pedidoSalvarButtonMouseReleased

    private void pedidoAdicionarPizzaButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoAdicionarPizzaButtonMouseReleased
        limparPizzaErroText();
        if (pedidosClienteComboBox.getSelectedIndex() == -1) {
            pedidoClienteErroText.setText("O cliente é obrigatorio!");
            return;
        }
        if (pedidoFormaComboBox.getSelectedIndex() == -1) {
            pedidoFormaErroText.setText("A forma é obrigatoria!");
            return;
        }
        if (dimensaoTextField.getText().isEmpty()) {
            dimensaoErroText.setText("A dimensao é obrigatoria!");
            return;
        }
        if ((pedidoSaboresComboBox1.getSelectedIndex() == -1) && (pedidoSaboresComboBox2.getSelectedIndex() == -1)) {
            pedidoSaborErroText.setText("A pizza precisa ter no minimo 1 sabor!");
            return;
        }

        double dimensao = Double.parseDouble(dimensaoTextField.getText());

        Cliente cliente = (Cliente) pedidosClienteComboBox.getSelectedItem();

        if (pedido == null) {
            pedido = new Pedido(cliente);
        }

        Pizza pizza = new Pizza();
        Forma forma = (Forma) pedidoFormaComboBox.getSelectedItem();

        switch (forma.getNome()) {
            case CIRCULAR:
                try {
                forma = new Circular(dimensao);
            } catch (InvalidSizeInput ex) {
                dimensaoErroText.setText(ex.getMessage());
                return;
            }
            break;
            case QUADRADO:
                try {
                forma = new Quadrado(dimensao);
            } catch (InvalidSizeInput ex) {
                dimensaoErroText.setText(ex.getMessage());
                return;
            }
            break;
            case TRIANGULO:
                try {
                forma = new Triangulo(dimensao);
            } catch (InvalidSizeInput ex) {
                dimensaoErroText.setText(ex.getMessage());
                return;
            }
            break;
        }
        pizza.setForma(forma);

        Sabor sabor1 = (Sabor) pedidoSaboresComboBox1.getSelectedItem();
        Sabor sabor2 = (Sabor) pedidoSaboresComboBox2.getSelectedItem();
        try {
            if (pedidoSaboresComboBox1.getSelectedIndex() != -1) {
                pizza.addSabor(sabor1);
            }
            if (pedidoSaboresComboBox2.getSelectedIndex() != -1) {
                pizza.addSabor(sabor2);
            }
        } catch (MaximumFlavorSize ex) {
        }

        pedido.addPizza(pizza);

        pedidoPrecoTotal.setText(pedido.getPreco() + "");

        this.pizzas.add(pizza);
        pizzaTableModel.atualizarTabela(this.pizzas);

        // clear pizza form
        limparPizzaForm();
    }//GEN-LAST:event_pedidoAdicionarPizzaButtonMouseReleased

    private void pedidosTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidosTableMouseReleased
        pedidoLinhaSelecionada = pedidosTable.getSelectedRow();
        if (pedidoLinhaSelecionada == -1) {
            return;
        }
        Pedido pedido = this.pedidos.get(pedidoLinhaSelecionada);
        this.pedido = pedido;

        preencherPedidoForm(pedido);

        this.pizzas = pedido.getPizzas();
        pizzaTableModel.atualizarTabela(pedido.getPizzas());
    }//GEN-LAST:event_pedidosTableMouseReleased

    private void atualizarPedidoButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarPedidoButtonMouseReleased
        pedidoLinhaSelecionada = pedidosTable.getSelectedRow();
        if (pedidoLinhaSelecionada == -1) {
            return;
        }
        Pedido pedido = this.pedidos.get(pedidoLinhaSelecionada);

        pedido.setStatus((StatusPedido) pedidoStatusComboBox.getSelectedItem());

        pedidoTableModel.atualizarTabela(this.pedidos);

        limparPedidoForm();
        limparNovoPedidoForm();
    }//GEN-LAST:event_atualizarPedidoButtonMouseReleased

    private void pizzasTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pizzasTableMouseReleased
        pizzaLinhaSelecionada = pizzasTable.getSelectedRow();
        if (pizzaLinhaSelecionada == -1) {
            return;
        }
        Pizza pizza = (Pizza) this.pizzaTableModel.getItens().get(pizzaLinhaSelecionada);
        formaComboBoxModel.setSelectedItem(pizza.getForma());
        dimensaoTextField.setText(pizza.getForma().getDimensao() + "");
        saboresComboBoxModel1.setSelectedItem(pizza.getSabores().get(0));

        Cliente cliente = pedido.getCliente();
        clienteComboBoxModel.setSelectedItem(cliente);

        if (pizza.getSabores().size() > 1) {
            saboresComboBoxModel2.setSelectedItem(pizza.getSabores().get(1));
        }
    }//GEN-LAST:event_pizzasTableMouseReleased

    private void atualizarPizzaButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarPizzaButtonMouseReleased
        pizzaLinhaSelecionada = pizzasTable.getSelectedRow();
        if (pizzaLinhaSelecionada == -1) {
            return;
        }
        System.out.println("views.Pizzaria.atualizarPizzaButtonMouseReleased()" + this.pizzas);
        Pizza pizza = (Pizza) this.pizzaTableModel.getItens().get(pizzaLinhaSelecionada);

        limparPizzaErroText();
        if (pedidosClienteComboBox.getSelectedIndex() == -1) {
            pedidoClienteErroText.setText("O cliente é obrigatorio!");
            return;
        }
        if (pedidoFormaComboBox.getSelectedIndex() == -1) {
            pedidoFormaErroText.setText("A forma é obrigatoria!");
            return;
        }
        if (dimensaoTextField.getText().isEmpty()) {
            dimensaoErroText.setText("A dimensao é obrigatoria!");
            return;
        }
        if ((pedidoSaboresComboBox1.getSelectedIndex() == -1) && (pedidoSaboresComboBox2.getSelectedIndex() == -1)) {
            pedidoSaborErroText.setText("A pizza precisa ter no minimo 1 sabor!");
            return;
        }

        pedido.setCliente((Cliente) pedidosClienteComboBox.getSelectedItem());

        double dimensao = Double.parseDouble(dimensaoTextField.getText());

        Forma forma = (Forma) pedidoFormaComboBox.getSelectedItem();
        switch (forma.getNome()) {
            case CIRCULAR:
                try {
                forma = new Circular(dimensao);
            } catch (InvalidSizeInput ex) {
                dimensaoErroText.setText(ex.getMessage());
                return;
            }
            break;
            case QUADRADO:
                try {
                forma = new Quadrado(dimensao);
            } catch (InvalidSizeInput ex) {
                dimensaoErroText.setText(ex.getMessage());
                return;
            }
            break;
            case TRIANGULO:
                try {
                forma = new Triangulo(dimensao);
            } catch (InvalidSizeInput ex) {
                dimensaoErroText.setText(ex.getMessage());
                return;
            }
            break;
        }
        pizza.setForma(forma);

        try {
            pizza.setSabores(new ArrayList<>());
        } catch (MaximumFlavorSize ex) {
        }
        Sabor sabor1 = (Sabor) pedidoSaboresComboBox1.getSelectedItem();
        Sabor sabor2 = (Sabor) pedidoSaboresComboBox2.getSelectedItem();
        try {
            if (pedidoSaboresComboBox1.getSelectedIndex() != -1) {
                pizza.addSabor(sabor1);
            }
            if (pedidoSaboresComboBox2.getSelectedIndex() != -1) {
                pizza.addSabor(sabor2);
            }
        } catch (MaximumFlavorSize ex) {
        }

        pedidoPrecoTotal.setText(pedido.getPreco() + "");

        this.pizzas.set(pizzaLinhaSelecionada, pizza);
        pizzaTableModel.atualizarTabela(this.pizzas);
        pedido.setPizzas((ArrayList<Pizza>) this.pizzas);

        limparPizzaForm();
        limparNovoPedidoForm();
    }//GEN-LAST:event_atualizarPizzaButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pizzaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pizzaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton atualizarPedidoButton;
    private javax.swing.JButton atualizarPizzaButton;
    private javax.swing.JButton clienteAtualizarButton;
    private javax.swing.JButton clienteCadastrarButton;
    private javax.swing.JLabel clienteErrorText;
    private javax.swing.JButton clienteExcluirButton;
    private javax.swing.JTextField clienteNomeField;
    private javax.swing.JButton clientePesquisarButton;
    private javax.swing.JTextField clientePesquisarText;
    private javax.swing.JTextField clienteSobreNomeField;
    private javax.swing.JTextField clienteTelefoneField;
    private javax.swing.JButton clientesLimparButton;
    private javax.swing.JPanel clientesPanel;
    private javax.swing.JTable clientesTable;
    private javax.swing.JLabel dimensaoErroText;
    private javax.swing.JFormattedTextField dimensaoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton pedidoAdicionarPizzaButton;
    private javax.swing.JLabel pedidoClienteErroText;
    private javax.swing.JComboBox<Forma> pedidoFormaComboBox;
    private javax.swing.JLabel pedidoFormaErroText;
    private javax.swing.JTextField pedidoIdentificador;
    private javax.swing.JPanel pedidoPanel;
    private javax.swing.JFormattedTextField pedidoPrecoTotal;
    private javax.swing.JLabel pedidoSaborErroText;
    private javax.swing.JComboBox<Sabor> pedidoSaboresComboBox1;
    private javax.swing.JComboBox<Sabor> pedidoSaboresComboBox2;
    private javax.swing.JButton pedidoSalvarButton;
    private javax.swing.JComboBox<StatusPedido> pedidoStatusComboBox;
    private javax.swing.JComboBox<Cliente> pedidosClienteComboBox;
    private javax.swing.JPanel pedidosPanel;
    private javax.swing.JTable pedidosTable;
    private javax.swing.JPanel pizzaPanel;
    private javax.swing.JTable pizzasTable;
    private javax.swing.JTextField saboresNomeText;
    private javax.swing.JPanel saboresPanel;
    private javax.swing.JButton saboresSalvarButton;
    private javax.swing.JTable saboresTable;
    private javax.swing.JComboBox<TipoPizza> saboresTipoComboBox;
    private javax.swing.JLabel saboresTipoErroText;
    private javax.swing.JLabel tipoErroText;
    private javax.swing.JTextField tipoNomeText;
    private javax.swing.JFormattedTextField tipoPrecoText;
    private javax.swing.JButton tipoSalvarButton;
    private javax.swing.JPanel tiposPanel;
    private javax.swing.JTable tiposTable;
    // End of variables declaration//GEN-END:variables
}
