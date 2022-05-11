package classes;

import java.text.NumberFormat;
import java.util.Locale;

public class ItemOS {
    private char tipo;
    private double preco;
    private int qtde;
    private Servico servico;
    private Peca peca; 

    public ItemOS(int qtde, Peca peca) {
        this.tipo = 'P';
        this.preco = peca.getPreco();
        this.qtde = qtde;
        this.peca = peca;
    }
    
    public ItemOS(int qtde, Servico servico) {
        this.tipo = 'S';
        this.preco = servico.getPreco();
        this.qtde = qtde;
        this.servico = servico;
    }

    /* -- GETTERS E SETTERS -- */

    /* tipo */
    
    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /* preco */
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /* qtde */
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    /* servico */
    public Servico getServico() {
        return servico;
    }
    
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    /* peca */
    public Peca getPeca() {
        return peca;
    }

    public void setPeça(Peca peca) {
        this.peca = peca;
    }
    
    /* -- OUTROS MÉTODOS -- */
    
    /* Adiciona ao estoque a quantidade que havia sido empregada ao ItemOS se este item for uma peça. */  
    public void devolver() {
        if (tipo == 'P') {
            peca.adicionarEstoque(qtde);
        }
    }
    
    /*
    toString comum, as únicas diferença são: 
    - O uso de um formatador para formatar o preço;
    - A saída será de acordo com o tipo do item.
    */
    @Override
    public String toString() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String saida = "";

        saida += "Preço: " + formatador.format(preco) + "\n";
        saida += "Quantidade: " + qtde + "\n";
        
        switch (tipo) {
            case 'P' -> saida += "Peça: " + peca.getDescricao() + " (Código: " + peca.getCodPeca() + ")\n";
        
            case 'S' -> saida += "Serviço: " + servico.getDescricao() + " (Código: " + servico.getCodServico() + ")\n";
        }

        return saida;
    }
}
