package excecoes.cliente;

public class CpfCadastradoException extends Exception{
    
    public CpfCadastradoException() {
        super("Este CPF já está cadastrado");
    }
}
