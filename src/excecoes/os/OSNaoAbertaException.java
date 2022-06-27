package excecoes.os;

public class OSNaoAbertaException extends Exception{
    
    public OSNaoAbertaException() {
        super("Essa operação só é permitida em OS que estejam abertas");
    }  
}