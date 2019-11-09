package loja.banco.tabelas.nota_fiscal;

import java.sql.Timestamp;

/**
 * NotaFiscalBean
 */
public class NotaFiscalBean {
    private char numero;
    private char serie;
    private int codCli;
    private Timestamp data;
    private char cancelada;

    public char getNumero() {
        return this.numero;
    }

    public void setNumero(char numero) {
        this.numero = numero;
    }

    public char getSerie() {
        return this.serie;
    }

    public void setSerie(char serie) {
        this.serie = serie;
    }

    public int getCodCli() {
        return this.codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public Timestamp getData() {
        return this.data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public char getCancelada() {
        return this.cancelada;
    }

    public void setCancelada(char cancelada) {
        this.cancelada = cancelada;
    }

}