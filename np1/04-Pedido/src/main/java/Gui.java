package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Gui
 */
// 4 – Faça usando GUI um programa que tenha os botões de Adicionar, vai
// adicionar o nome de um produto, o valor e a quantidade, um botão fechar
// compras, numa caixa de texto mostrar o pedido com as informações e o valor
// total da compra, um botão novo pedido que vai limpar todas as caixas de
// texto.

public class Gui extends JFrame implements WindowListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private List<String> listaProdutos = new ArrayList<>();
    private double valorTotal = 0;

    protected Dimension dFrame, dLabel, dTextField, dButton, dTextArea;
    protected JButton btnFecharCompras, btnAdicionarProduto, btnNovo;
    protected JLabel lblProduto, lblValor, lblQuantidade, lblDetalhes;
    protected JTextField txtProduto, txtValor, txtQuantidade;
    protected JTextArea txtDetalhes;

    public Gui() {
        dFrame = new Dimension(280, 510);
        dLabel = new Dimension(80, 20);
        dTextField = new Dimension(150, 20);
        dTextArea = new Dimension(240, 180);
        dButton = new Dimension(240, 40);

        btnAdicionarProduto = new JButton("Adicionar Produto");
        btnAdicionarProduto.setSize(dButton);
        btnAdicionarProduto.setLocation(20, 110);
        btnAdicionarProduto.addActionListener(this);

        lblProduto = new JLabel("Produto");
        lblProduto.setSize(dLabel);
        lblProduto.setLocation(20, 25);

        txtProduto = new JTextField();
        txtProduto.setSize(dTextField);
        txtProduto.setLocation(110, 25);

        lblValor = new JLabel("Valor");
        lblValor.setSize(dLabel);
        lblValor.setLocation(20, 50);

        txtValor = new JTextField();
        txtValor.setSize(dTextField);
        txtValor.setLocation(110, 50);

        lblQuantidade = new JLabel("Quantidade");
        lblQuantidade.setSize(dLabel);
        lblQuantidade.setLocation(20, 75);

        txtQuantidade = new JTextField();
        txtQuantidade.setSize(dTextField);
        txtQuantidade.setLocation(110, 75);

        lblDetalhes = new JLabel("Detalhes da Compra");
        lblDetalhes.setSize(140, 20);
        lblDetalhes.setLocation(20, 210);

        txtDetalhes = new JTextArea();
        txtDetalhes.setSize(dTextArea);
        txtDetalhes.setBackground(Color.RED);
        txtDetalhes.setForeground(Color.WHITE);
        txtDetalhes.setFont(new Font("Dialog", Font.BOLD, 10));
        txtDetalhes.setLocation(20, 230);

        btnFecharCompras = new JButton("Fechar Compra");
        btnFecharCompras.setSize(dButton);
        btnFecharCompras.setLocation(20, 160);
        btnFecharCompras.addActionListener(this);

        btnNovo = new JButton("Novo Pedido");
        btnNovo.setSize(dButton);
        btnNovo.setLocation(20, 420);
        btnNovo.addActionListener(this);

        setTitle("Pedidos");
        setResizable(false);
        setSize(dFrame);
        setLocation(400, 200);
        setBackground(Color.cyan);
        setLayout(null);
        setVisible(true);

        addWindowListener(this);

        add(lblProduto);
        add(txtProduto);
        add(btnAdicionarProduto);
        add(lblValor);
        add(txtValor);
        add(lblQuantidade);
        add(txtQuantidade);
        add(lblDetalhes);
        add(txtDetalhes);
        add(btnFecharCompras);
        add(btnNovo);

        txtDetalhes.repaint();
        listaProdutos.add("PRODUTO" + "\t" + "VALOR" + "\t" + "QTD.");
    }

    private void addProduto() {
        try {
            listaProdutos.add(txtProduto.getText() + "\t" + txtValor.getText() + "\t" + txtQuantidade.getText());
            this.valorTotal += (Double.parseDouble(txtValor.getText()) * Double.parseDouble(txtQuantidade.getText()));
            txtProduto.setText("");
            txtValor.setText("");
            txtQuantidade.setText("");
            txtProduto.requestFocus();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    private void fecharPedido() {
        for (String produtos : listaProdutos) {
            txtDetalhes.append(produtos + "\n");
        }
        txtDetalhes.append("---------------------------\n");
        txtDetalhes.append("TOTAL = \t\t" + String.valueOf(valorTotal));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFecharCompras) {
            try {
                fecharPedido();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        }

        if (e.getSource() == btnAdicionarProduto) {
            try {
                addProduto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        if (e.getSource() == btnNovo) {
            try {
                listaProdutos.clear();
                listaProdutos.add("PRODUTO" + "\t" + "VALOR" + "\t" + "QTD.");
                txtDetalhes.setText("");
                txtProduto.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}