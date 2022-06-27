package excecoes;

public class CampoVazioException extends Exception{
    
    public CampoVazioException(String nomeCampo) {
        super("O campo \"" + nomeCampo + "\" não pode estar vazio");
    }
}
