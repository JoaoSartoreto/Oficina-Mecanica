package excecoes.produto;

public class ProdutoNaoEncontradoException extends Exception{
    
    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado");
    }
}