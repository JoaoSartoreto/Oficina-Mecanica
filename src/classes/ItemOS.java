package classes;

public class ItemOS {
    private char tipo;
    private double preco;
    private int qtde;
    private Servico servico;
    private Peca peca; 

    public ItemOS(char tipo, double preco, int qtde, Peca peca) {
        this.tipo = tipo;
        this.preco = preco;
        this.qtde = qtde;
        this.peca = peca;
    }
    
    public ItemOS(char tipo, double preco, int qtde, Servico servico) {
        this.tipo = tipo;
        this.preco = preco;
        this.qtde = qtde;
        this.servico = servico;
    }

    // GETTERS E SETTERS

    // tipo
    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    // preco
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // qtde
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    // peca
    public Peca getPeca() {
        return peca;
    }

    public void setPeça(Peca peca) {
        this.peca = peca;
    }
    
    // OUTROS MÉTODOS

    public String toString() {
        String saida ="";
        
        saida += "Tipo: "+this.tipo+"\n";
        saida += "Preço: "+this.preco+"\n";
        saida += "Quantidade: "+this.qtde+"\n";

        switch (tipo) {
            case 'P':
                saida += this.peca.toString()+"\n";
                break;
        
            case 'S':
                saida += this.servico.toString()+"\n";
                break;
        }

        return saida;
    }

    // Adiciona ao estoque a quantidade que havia sido empregada ao ItemOS
    public void devolver() {
        if (tipo == 'P') {
            peca.adicionarEstoque(this.qtde);
        }
    }
}
