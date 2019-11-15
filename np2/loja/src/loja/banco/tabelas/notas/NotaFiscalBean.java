package loja.banco.tabelas.notas;

import java.time.LocalDate;

/**
 * ClienteBean
 */
public class NotaFiscalBean {

    private char[] numero;
    private char[] serie;
    private int codCli;
    private LocalDate data;
    private char[] cancelada;

    public char[] getNumero() {
        return numero;
    }

    public void setNumero(char[] numero) {
        this.numero = numero;
    }

    public char[] getSerie() {
        return serie;
    }

    public void setSerie(char[] serie) {
        this.serie = serie;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public char[] getCancelada() {
        return cancelada;
    }

    public void setCancelada(char[] cancelada) {
        this.cancelada = cancelada;
    }

}
