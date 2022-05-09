package classes;

public class ItemOS {
    private char tipo;
    private double preco;
    private int qtde;
    private Servico servico;
    private Peca peca; 

    public ItemOS(char tipo, int qtde, Peca peca) {
        this.tipo = tipo;
        this.preco = peca.getPreco();
        this.qtde = qtde;
        this.peca = peca;
    }
    
    public ItemOS(char tipo, int qtde, Servico servico) {
        this.tipo = tipo;
        this.preco = servico.getPreco();
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

    @Override
    public String toString() {
        String saida ="";
        
        saida += "Tipo: " + tipo + "\n";
        saida += "Preço: " + preco + "\n";
        saida += "Quantidade: " + qtde + "\n";

        switch (tipo) {
            case 'P' -> saida += this.peca.toString() + "\n";
        
            case 'S' -> saida += this.servico.toString() + "\n";
        }

        return saida;
    }

    // Adiciona ao estoque a quantidade que havia sido empregada ao ItemOS
    public void devolver() {
        if (tipo == 'P') {
            peca.adicionarEstoque(qtde);
        }
    }
    
}
