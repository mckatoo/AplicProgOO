package loja.banco.tabelas.pneus;

import java.math.BigDecimal;

/**
 * PneuBean
 */
public class PneuBean {
    private int codPneu;
    private String descricao;
    private String medidas;
    private BigDecimal preco;
    private char ativo;

    public int getCodPneu() {
        return this.codPneu;
    }

    public void setCodPneu(int codPneu) {
        this.codPneu = codPneu;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMedidas() {
        return this.medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public char getAtivo() {
        return this.ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

}