package excecoes.os;

public class OSNaoEncontradaException extends Exception{
    
    public OSNaoEncontradaException() {
        super("Ordem de serviço não encontrada");
    }
}
