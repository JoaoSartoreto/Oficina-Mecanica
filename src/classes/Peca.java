package classes;

public class Peca {
    private static int qtdePecas;
    
    private int codPeca;
    private String descricao;
    private double preco;
    private int qtdeEstoque;
        
    public Peca (String descricao, double preco, int qtdeEstoque) {
        qtdePecas++;
        this.codPeca = qtdePecas;
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

    public void setPreco(double preco) {
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
        
        return false;
    }
       
    // Subtrai uma quantidade de peças somente se for válido.
    // Devolve um boolean representando o sucesso da operação.
    public boolean subtrairEstoque (int n) {
        if (n <= 0) 
            return false;
        else if (n > this.qtdeEstoque)
            return false;
        
        this.qtdeEstoque = this.qtdeEstoque - n;
        return true;
    }
    
    
    //toString
    @Override
    public String toString() {
        String saida = "";

        saida += "Codigo: " + codPeca + "\n";
        saida += "Descricao: " + descricao + "\n";
        saida += "Preco: " + preco + "\n";
        saida += "Estoque: " + qtdeEstoque + "\n";

        return saida;
    }
    
}