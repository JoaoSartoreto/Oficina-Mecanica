package excecoes;

public class QuantidadeInicialEstoqueInvalidaException extends Exception {
    
    public QuantidadeInicialEstoqueInvalidaException() {
        super("Quantididade inicial do estoque inválida");
    }
}
