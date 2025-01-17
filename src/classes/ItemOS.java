package classes;

import excecoes.QuantidadeInvalidaException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class ItemOS implements Serializable{
    private char tipo;
    private double preco;
    private int qtde;
    private Produto produto;

    public ItemOS(int qtde, Peca peca) {
        this.tipo = 'P';
        this.qtde = qtde;
        this.preco = peca.getPreco() * qtde;
        this.produto = peca;
    }
    
    public ItemOS(int qtde, Servico servico) {
        this.tipo = 'S';
        this.qtde = qtde;
        this.preco = servico.getPreco() * qtde;
        this.produto = servico;
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
    
    /* produto */

    public Produto getProduto() {
        return produto;
    }
    
    
    /* -- OUTROS MÉTODOS -- */
    
    /* Adiciona ao estoque a quantidade que havia sido empregada ao ItemOS se este item for uma peça. */  
    public void devolver() {
        if (tipo == 'P') {
            Peca peca = (Peca)produto;
            try {
                peca.adicionarEstoque(qtde);
            } catch (QuantidadeInvalidaException e) {}
            /* Para este caso a quantidade sempre será válida, então não ocorrerá nenhuma exceção */
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
        
        saida += "Tipo: ";
        if (tipo == 'P') saida += "Peça\n";
        if (tipo == 'S') saida += "Serviço\n";
        saida += this.produto.toString();
        saida += "Quantidade: " + qtde + "\n";
        saida += "Preço Total: " + formatador.format(preco) + "\n";

        return saida;
    }
}
