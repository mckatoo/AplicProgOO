package loja.banco.tabelas.clientes;

/**
 * ClienteBean
 */
public class ClienteBean {
    private int codCli;
    private String nome;
    private String endereco;
    private char[] estado;

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public char[] getEstado() {
        return estado;
    }

    public void setEstado(char[] estado) {
        this.estado = estado;
    }

}