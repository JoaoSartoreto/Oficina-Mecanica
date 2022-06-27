package excecoes.itemos;

public class AdicionarItemOSNaoAbertaException extends Exception {
    
    public AdicionarItemOSNaoAbertaException(){
        super("Só é permitido adicionar itens a ordens de serviço abertas");
    }    
}