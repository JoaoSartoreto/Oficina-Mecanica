package excecoes;

public class EstoqueInsuficienteException extends Exception{
    
    public EstoqueInsuficienteException() {
        super("Não há peças suficientes no estoque");
    }   
}