package excecoes.itemos;

public class RemoverItemOSNaoAbertaException extends Exception {
    
    public RemoverItemOSNaoAbertaException() {
        super("Só é permitido remover itens de ordens de serviço abertas");
    }
}
