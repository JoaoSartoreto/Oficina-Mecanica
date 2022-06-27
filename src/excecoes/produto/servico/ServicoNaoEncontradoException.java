package excecoes.produto.servico;

public class ServicoNaoEncontradoException extends Exception {
    
    public ServicoNaoEncontradoException() {
        super("Serviço não encontrado");
    }
}
