package classes;

public class Peca {
    private int codPeca;
    private String descricao;
    private double preco;
    private int qtdeEstoque;
        
    public Peca (int codPeca, String descricao, double preco, int qtdeEstoque) {
        this.codPeca = codPeca;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdeEstoque = qtdeEstoque;
    }
    
    // GETTERS E SETTERS
    
    // codPeca
    public int getCodPeca() {
        return codPeca;
    }

    public void setCodPeca(int codPeca) {
        this.codPeca = codPeca;
    }

    // descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // preco
    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    // qtdeEstoque  
    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
    
    // OUTROS MÉTODOS
    
    // Adiciona uma quantidade de peças somente se for válido.
    // Devolve um boolean representando o sucesso da operação.
    public boolean adicionarEstoque (int n) {
        if (n > 0) {
            this.qtdeEstoque = this.qtdeEstoque + n;
            return true;
        }
        else {

            return false;
        }
    }
       
    // Subtrai uma quantidade de peças somente se for válido.
    // Devolve um boolean representando o sucesso da operação.
    public boolean subtrairEstoque (int n) {
        if (n <= 0) {
            return false;
        }
        else if (n > this.qtdeEstoque) {
            return false;
        }
        else {
            this.qtdeEstoque = this.qtdeEstoque - n;
            return true;
        }
    }
    
    @Override
    public String toString() {
        String saida = "";
        saida += "Codigo: " + this.codPeca + "\n";
        saida += "Descricao: " + this.descricao + "\n";
        saida += "Preco: " + this.preco + "\n";
        saida += "Estoque: " + this.qtdeEstoque + "\n";
        return saida;
    }
    
}
