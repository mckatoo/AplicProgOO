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
    private char[] ativo;

    public int getCodPneu() {
        return codPneu;
    }

    public void setCodPneu(int codPneu) {
        this.codPneu = codPneu;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public char[] getAtivo() {
        return ativo;
    }

    public void setAtivo(char[] ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return getCodPneu() + " - " + getDescricao() + " " + getPreco();
    }
    
    
}