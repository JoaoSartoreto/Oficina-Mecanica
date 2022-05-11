package classes;

import java.text.NumberFormat;
import java.util.Locale;

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
    
    /* -- GETTERS E SETTERS -- */
    
    /* codPeca */
    public int getCodPeca() {
        return codPeca;
    }

    public void setCodPeca(int codPeca) {
        this.codPeca = codPeca;
    }

    /* descricao */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /* preco */
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /* qtdeEstoque */  
    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
    
    /* -- OUTROS MÉTODOS -- */
    
    /*
    Adiciona uma quantidade de peças no estoque desde que a quantidade seja maior que 0.
    Devolve um boolean representando o sucesso da operação.
    */
    public boolean adicionarEstoque (int n) {
        if (n > 0) {
            this.qtdeEstoque = this.qtdeEstoque + n;
            return true;
        }
        
        return false;
    }
    
    /*
    Subtrai uma quantidade de peças do estoque desde que a quantidade seja maior que 0 e seja uma quantidade
    disponível no estoque.
    Devolve um boolean representando o sucesso da operação.
    */
    public boolean subtrairEstoque (int n) {
        if (n <= 0) 
            return false;
        else if (n > this.qtdeEstoque)
            return false;
        
        this.qtdeEstoque = this.qtdeEstoque - n;
        return true;
    }
    
    /*
    Um toString comum, a única diferença é o uso de um formatador para o preço.
    */
    @Override
    public String toString() {    
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String saida = "";

        saida += "Código: " + codPeca + "\n";
        saida += "Descrição: " + descricao + "\n";
        saida += "Preco: " + formatador.format(preco) + "\n";
        saida += "Quantidade em estoque: " + qtdeEstoque + "\n";

        return saida;
    }
    
}