package main.java;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Gui
 */
// 2 – Faça usando GUI um programa que peça 2 notas, calcule a média e
// mostre a situação do aluno conforme as regras da UNIESI.

public class Gui extends JFrame implements WindowListener, ActionListener {

    private static final long serialVersionUID = 1L;
    protected Dimension dFrame, dLabel, dTextField, dButton, dLabelLarge;
    protected JButton btnCalculaNota;
    protected JLabel lblNP1, lblNP2;
    protected JTextField txtNP1, txtNP2, lblMedia, lblSituacao;
    protected Font fontFull;

    public Gui() {
        fontFull = new Font("Dialog", Font.BOLD, 12);

        dFrame = new Dimension(280, 220);
        dLabel = new Dimension(80, 20);
        dLabelLarge = new Dimension(240, 20);
        dTextField = new Dimension(150, 20);
        dButton = new Dimension(240, 40);

        lblNP1 = new JLabel("NP1");
        lblNP1.setSize(dLabel);
        lblNP1.setLocation(20, 25);

        txtNP1 = new JTextField();
        txtNP1.setSize(dTextField);
        txtNP1.setLocation(110, 25);

        lblNP2 = new JLabel("NP2");
        lblNP2.setSize(dLabel);
        lblNP2.setLocation(20, 50);

        txtNP2 = new JTextField();
        txtNP2.setSize(dTextField);
        txtNP2.setLocation(110, 50);

        lblMedia = new JTextField("");
        lblMedia.setSize(dLabelLarge);
        lblMedia.setLocation(20, 75);
        lblMedia.setHorizontalAlignment(SwingConstants.CENTER);
        lblMedia.setEditable(false);
        lblMedia.setRequestFocusEnabled(false);
        lblMedia.setBackground(Color.lightGray);
        lblMedia.setForeground(Color.WHITE);
        lblMedia.setFont(fontFull);

        lblSituacao = new JTextField("");
        lblSituacao.setSize(dLabelLarge);
        lblSituacao.setLocation(20, 100);
        lblSituacao.setHorizontalAlignment(SwingConstants.CENTER);
        lblSituacao.setEditable(false);
        lblSituacao.setRequestFocusEnabled(false);
        lblSituacao.setBackground(Color.lightGray);
        lblSituacao.setForeground(Color.WHITE);
        lblSituacao.setFont(fontFull);

        btnCalculaNota = new JButton("Calcular Média");
        btnCalculaNota.setSize(dButton);
        btnCalculaNota.setLocation(20, 130);
        btnCalculaNota.addActionListener(this);

        setTitle("Situação do Aluno");
        setResizable(false);
        setSize(dFrame);
        setLocation(400, 200);
        setBackground(Color.cyan);
        setLayout(null);
        setVisible(true);

        addWindowListener(this);

        add(lblNP1);
        add(txtNP1);
        add(lblNP2);
        add(txtNP2);
        add(lblMedia);
        add(lblSituacao);
        add(btnCalculaNota);
    }

    private double calcularMedia(double np1, double np2) {
        return (np1 + np2) / 2;
    }

    private Situacao verificarSituacao(double media) {
        if (media >= 7)
            return Situacao.APROVADO;
        return Situacao.EXAME;
    }

    private void formatarLblMediaSituacao(Situacao situacao) {
        if (situacao.toString() == "APROVADO") {
            lblMedia.setBackground(Color.blue);
            lblMedia.setFont(fontFull);
            lblSituacao.setBackground(Color.blue);
            lblSituacao.setFont(fontFull);
        } else {
            lblMedia.setBackground(Color.red);
            lblMedia.setFont(fontFull);
            lblSituacao.setBackground(Color.red);
            lblSituacao.setFont(fontFull);
        }
    }

    private void limpar() {
        txtNP1.setText("");
        txtNP2.setText("");
        txtNP1.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculaNota) {
            try {
                double media = calcularMedia(Double.parseDouble(txtNP1.getText()),
                        Double.parseDouble(txtNP2.getText()));
                Situacao situacao = verificarSituacao(media);
                lblMedia.setText(String.valueOf(media));
                lblSituacao.setText(situacao.toString());
                formatarLblMediaSituacao(situacao);
                limpar();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
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