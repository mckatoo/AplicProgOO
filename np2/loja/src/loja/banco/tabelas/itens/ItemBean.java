package loja.banco.tabelas.itens;

import java.math.BigDecimal;

/**
 * ItemBean
 */
public class ItemBean {
    private char[] numero;
    private char [] serie;
    private int item;
    private int codPneu;
    private int qtde;
    private BigDecimal preco;

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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCodPneu() {
        return codPneu;
    }

    public void setCodPneu(int codPneu) {
        this.codPneu = codPneu;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    
}