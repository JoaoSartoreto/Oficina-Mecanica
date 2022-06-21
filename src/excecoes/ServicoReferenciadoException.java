package excecoes;

public class ServicoReferenciadoException extends Exception{
    
    public ServicoReferenciadoException() {
        super("Não é permitido excluir serviços que estejam cadastrados em alguma OS");
    }  
}
