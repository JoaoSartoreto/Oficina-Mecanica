package excecoes.produto.peca;

public class QuantidadeEstoqueInvalidaException extends Exception {
    
    public QuantidadeEstoqueInvalidaException() {
        super("Quantididade de estoque inválida");
    }
}
