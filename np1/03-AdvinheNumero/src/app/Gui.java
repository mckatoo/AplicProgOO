package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Gui
 */
// 3 - Escreva um programa que jogue “adivinhe o número”: o programa
// escolhe um número a ser adivinhado, selecionando-o randomicamente no
// intervalo de 1-100. O programa mostra uma mensagem (JLabel) – Eu tenho
// um número entre 1 e 100, você pode adivinhá-lo? Entre com seu chute.
// Um caixa de texto deve ser usado na captura do valor. Para cada tentativa de
// adivinhação um Label deve apresentar o intervalo em que o número
// encontra-se.
// • Quando a resposta estiver correta, você deve mostrar a frase “Correto!” e
// não permitir mais a edição na caixa de texto.
// • Um botão deve permitir um novo jogo. Quando o botão é clicado, um novo
// número randômico deve ser gerado e a caixa de texto ser editável.

public class Gui extends JFrame implements WindowListener, ActionListener {

    private static final long serialVersionUID = 1L;
    final Random random = new Random();
    protected Dimension dFrame, dButton;
    protected JButton btnJogar, btnNovoJogo;
    protected JLabel lblMensagemInicial, lblIntervalo, txtIntervalo;
    protected JTextField txtValor;
    private int numeroAleatorio, numeroEscolhido;

    public Gui() {
        dFrame = new Dimension(280, 350);
        dButton = new Dimension(240, 40);

        lblMensagemInicial = new JLabel(
                "<html><body>Eu tenho um número entre 1 e 100, você pode adivinhá-lo? Entre com seu chute.</body></html>");
        lblMensagemInicial.setSize(240, 60);
        lblMensagemInicial.setLocation(20, 20);

        txtValor = new JTextField();
        txtValor.setSize(240, 20);
        txtValor.setLocation(20, 90);

        btnJogar = new JButton("Jogar");
        btnJogar.setSize(dButton);
        btnJogar.setLocation(20, 130);
        btnJogar.addActionListener(this);

        lblIntervalo = new JLabel("<html><body>Intervalo em que o número encontra-se.</body></html>");
        lblIntervalo.setSize(240, 60);
        lblIntervalo.setLocation(20, 180);

        txtIntervalo = new JLabel("1-100");
        txtIntervalo.setSize(240, 20);
        txtIntervalo.setLocation(20, 230);

        btnNovoJogo = new JButton("Novo Jogo");
        btnNovoJogo.setSize(dButton);
        btnNovoJogo.setLocation(20, 260);
        btnNovoJogo.addActionListener(this);

        setTitle("Advinhe o Número");
        setResizable(false);
        setSize(dFrame);
        setLocation(400, 200);
        setBackground(Color.cyan);
        setLayout(null);
        setVisible(true);

        addWindowListener(this);

        add(lblMensagemInicial);
        add(txtValor);
        add(btnJogar);
        add(btnNovoJogo);
        add(lblIntervalo);
        add(txtIntervalo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJogar) {
            try {
                this.numeroAleatorio = random.nextInt(100);
                this.numeroEscolhido = Integer.parseInt(txtValor.getText());
                if (numeroAleatorio == numeroEscolhido) {
                    JOptionPane.showMessageDialog(null, "Correto!");
                    txtValor.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Errou! O valor gerado é " + String.valueOf(this.numeroAleatorio));
                    txtValor.setEditable(false);
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        }
        if (e.getSource() == btnNovoJogo) {
            try {
                txtValor.setEditable(true);
                txtValor.setText("");
                txtValor.requestFocus();
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