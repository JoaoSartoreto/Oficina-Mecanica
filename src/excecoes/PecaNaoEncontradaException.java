package excecoes;

public class PecaNaoEncontradaException extends Exception{
    
    public PecaNaoEncontradaException() {
        super("Peça não encontrada");
    }
}
