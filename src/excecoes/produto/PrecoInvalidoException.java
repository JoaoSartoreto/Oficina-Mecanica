package excecoes.produto;

public class PrecoInvalidoException extends Exception{
    
    public PrecoInvalidoException() {
        super("Preço inválido");
    }
}
