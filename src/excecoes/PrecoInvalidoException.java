package excecoes;

public class PrecoInvalidoException extends Exception{
    
    public PrecoInvalidoException() {
        super("Preço inválido");
    }
}
