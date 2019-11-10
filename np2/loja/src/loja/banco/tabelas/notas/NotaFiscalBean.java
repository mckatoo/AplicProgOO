package loja.banco.tabelas.notas;

import java.sql.Date;

/**
 * ClienteBean
 */
public class NotaFiscalBean {
    private char[] numero;
    private char[] serie;
    private int codCli;
    private Date data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public char[] getCancelada() {
        return cancelada;
    }

    public void setCancelada(char[] cancelada) {
        this.cancelada = cancelada;
    }
    
    
}