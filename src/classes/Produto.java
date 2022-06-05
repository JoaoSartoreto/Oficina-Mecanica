/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author joovitor
 */
public abstract class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private static int qtdProduto;

    public Produto(String descricao, double preco) {
        qtdProduto++;
        this.codigo = qtdProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString()
    {
        String saida="";
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        
        saida += "Código: " + this.codigo + "\n";
        saida += "Descrição: " + this.descricao + "\n";
        saida += "Preco: " + formatador.format(this.preco) + "\n";
        
        return saida;
    }
}
