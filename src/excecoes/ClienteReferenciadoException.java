package excecoes;

public class ClienteReferenciadoException extends Exception {
    
    public ClienteReferenciadoException() {
        super("Não é permitido excluir clientes que estejam cadastrados em alguma OS");
    }  
}