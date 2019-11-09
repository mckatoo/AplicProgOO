package loja.banco.tabelas.itens;

import java.math.BigDecimal;

/**
 * ItemBean
 */
public class ItemBean {
    private char numero;
    private char serie;
    private int item;
    private int codPneu;
    private int qtde;
    private BigDecimal preco;

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

    public int getItem() {
        return this.item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCodPneu() {
        return this.codPneu;
    }

    public void setCodPneu(int codPneu) {
        this.codPneu = codPneu;
    }

    public int getQtde() {
        return this.qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}