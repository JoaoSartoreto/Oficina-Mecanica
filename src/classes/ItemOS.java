/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1poo;

import java.util.ArrayList;

/**
 *
 * @author joovitor
 */
class ItemOS {
    private char tipo;
    private double preço;
    private int qtde;
    private Serviço serviço;
    private Peça peça; 

    public ItemOS(char tipo, double preço, int qtde, Peça peça) {
        this.tipo = tipo;
        this.preço = preço;
        this.qtde = qtde;
        this.peça = peça;
    }
    
    public ItemOS(char tipo, double preço, Serviço serviço) {
        this.tipo = tipo;
        this.preço = preço;
        this.serviço = serviço;
    }

    public String toString()
    {
        String saida ="";
        
        if(this.peça!=null)
        {
            saida += "Tipo: "+this.tipo+"\n";
            saida += "Preço: "+this.preço+"\n";
            saida += "Quantidade: "+this.qtde+"\n";
            saida += this.peça.toString()+"\n";
        }
        else
        {
            saida += "Tipo: "+this.tipo+"\n";
            saida += "Preço: "+this.preço+"\n";
            saida += this.serviço.toString()+"\n";
        }
        return saida;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }
    
    
    
}
