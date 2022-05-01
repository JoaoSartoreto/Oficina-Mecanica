package peca;

public class Peca {
    private int codPeca;
    private String descricao;
    private int preco;
    private int qtdeEstoque;
        
    public Peca (int codPeca, String descricao, int preco, int qtdeEstoque) {
        this.codPeca = codPeca;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getCodPeca() {
        return codPeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPreco() {
        return preco;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setCodPeca(int codPeca) {
        this.codPeca = codPeca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
    
    
}
