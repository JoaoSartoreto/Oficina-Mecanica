package classes;


public class Peca extends Produto{
    private int qtdeEstoque;

    public Peca(int qtdeEstoque, String descricao, double preco) {
        super(descricao, preco);
        this.qtdeEstoque = qtdeEstoque;
    }

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
        
        String saida = super.toString();

        saida += "Quantidade em estoque: " + qtdeEstoque + "\n";

        return saida;
    }
    
}