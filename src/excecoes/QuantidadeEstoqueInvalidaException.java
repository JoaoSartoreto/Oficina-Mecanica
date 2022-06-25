package excecoes;

public class QuantidadeEstoqueInvalidaException extends Exception {
    
    public QuantidadeEstoqueInvalidaException() {
        super("Quantididade de estoque inválida");
    }
}
