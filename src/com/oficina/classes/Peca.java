package com.oficina.classes;

public class Peca {
    private int codPeca;
    private String descricao;
    private float preco;
    private int qtdeEstoque;
        
    public Peca (int codPeca, String descricao, float preco, int qtdeEstoque) {
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

    public float getPreco() {
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
    
    public void addPeca (int qtdeEstoque, int n) {
        this.qtdeEstoque = qtdeEstoque + n;
    }
    
    public boolean addPeca (int n) {
        if (n > 0) {
            this.qtdeEstoque = this.qtdeEstoque + n;
            return true;
        }
        else {

            return false;
        }
    }
    
    public boolean subPeca (int n) {
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
    
    public String toString() {
        String saida = "";
        saida += "Codigo: " + this.codPeca + "\n";
        saida += "Descricao: " + this.descricao + "\n";
        saida += "Preco: " + this.preco + "\n";
        saida += "Estoque: " + this.qtdeEstoque + "\n";
        return saida;
    }
    
}
