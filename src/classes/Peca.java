package classes;

import excecoes.EstoqueInsuficienteException;
import excecoes.PrecoInvalidoException;
import excecoes.QuantidadeEstoqueInvalidaException;
import excecoes.QuantidadeInvalidaException;

public class Peca extends Produto{
    private int qtdeEstoque;
    private static int qtdPeca;
    
    public Peca(int qtdeEstoque, String descricao, double preco) throws PrecoInvalidoException, QuantidadeEstoqueInvalidaException {
        super(++qtdPeca, descricao, preco);
        if (qtdeEstoque < 0) {
            qtdPeca--;
            throw new QuantidadeEstoqueInvalidaException();
        }
        this.qtdeEstoque = qtdeEstoque;
    }
    
    /* -- GETTERS E SETTERS -- */
    
    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) throws QuantidadeEstoqueInvalidaException {
        if (qtdeEstoque < 0) throw new QuantidadeEstoqueInvalidaException();
        this.qtdeEstoque = qtdeEstoque;
    }
        
    
    /* -- OUTROS MÉTODOS -- */
    
    /*
    Adiciona uma quantidade de peças no estoque desde que a quantidade seja maior que 0,
    senão é lançada uma exceção.
    */
    public void adicionarEstoque (int n) throws QuantidadeInvalidaException {
        if (n <= 0) throw new QuantidadeInvalidaException();
        this.qtdeEstoque = this.qtdeEstoque + n;
    }
    
    /*
    Subtrai uma quantidade de peças do estoque desde que a quantidade seja maior que 0 e seja uma quantidade
    disponível no estoque, senão é uma lançada uma exceção específica para o problema.
    */
    public void subtrairEstoque (int n) throws QuantidadeInvalidaException, EstoqueInsuficienteException {
        if (n <= 0) throw new QuantidadeInvalidaException();
        if (n > this.qtdeEstoque) throw new EstoqueInsuficienteException();
        
        this.qtdeEstoque = this.qtdeEstoque - n;
    }
    
    @Override
    public String toString() {    
        
        String saida = super.toString();

        saida += "Quantidade em estoque: " + qtdeEstoque + "\n";

        return saida;
    }
    
}