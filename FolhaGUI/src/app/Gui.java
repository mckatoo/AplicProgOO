package app;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Gui
 */

// Crie uma GUI que solicite a entrada do Salário, quando clicado em calcular
// folha, retorne o valor do desconto do INSS e do Salário Líquido.

// Coloque o botão sair tb.
public class Gui extends JFrame implements WindowListener, ActionListener {

    private static final long serialVersionUID = 1L;

    protected Dimension dFrame, dLabel, dTextField, dButton;
    protected Button btnSair, btnCalcular;
    protected Label lblSalario, lblINSS, lblLiquido;
    protected TextField txtSalario, txtINSS, txtLiquido;

    public Gui() {
        dFrame = new Dimension(270, 240);
        dLabel = new Dimension(70, 20);
        dTextField = new Dimension(150, 20);

        lblSalario = new Label("Salário");
        lblSalario.setSize(dLabel);
        lblSalario.setLocation(25, 25);

        txtSalario = new TextField(null);
        txtSalario.setSize(dTextField);
        txtSalario.setLocation(100, 25);

        btnCalcular = new Button("Calcular Folha");
        btnCalcular.setSize(new Dimension(230, 40));
        btnCalcular.setLocation(25, 50);
        btnCalcular.addActionListener(this);

        lblINSS = new Label("INSS");
        lblINSS.setSize(dLabel);
        lblINSS.setLocation(25, 100);

        txtINSS = new TextField(null);
        txtINSS.setSize(dTextField);
        txtINSS.setLocation(100, 100);

        lblLiquido = new Label("Líquido");
        lblLiquido.setSize(dLabel);
        lblLiquido.setLocation(25, 130);

        txtLiquido = new TextField(null);
        txtLiquido.setSize(dTextField);
        txtLiquido.setLocation(100, 130);

        btnSair = new Button("Sair");
        btnSair.setSize(new Dimension(230, 40));
        btnSair.setLocation(25, 160);
        btnSair.addActionListener(this);

        setTitle("Calculo de Folha");
        setResizable(false);
        setSize(dFrame);
        setLocation(400, 200);
        setBackground(Color.cyan);
        setLayout(null);
        setVisible(true);

        addWindowListener(this);

        add(lblSalario);
        add(txtSalario);
        add(btnCalcular);
        add(lblINSS);
        add(txtINSS);
        add(lblLiquido);
        add(txtLiquido);
        add(btnSair);
    }

    private void CalculaSalario(String salario) {
        Double salarioDouble = Double.parseDouble(salario);
        Double inss;
        if (salarioDouble <= 1693.72) {
            inss = salarioDouble * 0.08;
        } else if (salarioDouble <= 2822.90)
            inss = salarioDouble * 0.09;
        else if (salarioDouble <= 5645.80)
            inss = salarioDouble * 0.11;
        else
            inss = 621.04;

        txtINSS.setText(Double.toString(inss));
        txtLiquido.setText(Double.toString(salarioDouble - inss));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSair) {
            System.exit(0);
        }

        if (e.getSource() == btnCalcular) {
            try {
                CalculaSalario(txtSalario.getText());
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