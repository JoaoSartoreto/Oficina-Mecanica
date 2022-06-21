package excecoes;

public class PecaReferenciadaException extends Exception{
    
    public PecaReferenciadaException() {
        super("Não é permitido excluir peças que estejam cadastradas em alguma OS");
    }   
}