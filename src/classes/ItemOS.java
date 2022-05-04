package classes;

class ItemOS {
    private char tipo;
    private double preço;
    private int qtde;
    private Servico serviço;
    private Peca peça; 

    public ItemOS(char tipo, double preço, int qtde, Peca peça) {
        this.tipo = tipo;
        this.preço = preço;
        this.qtde = qtde;
        this.peça = peça;
    }
    
    public ItemOS(char tipo, double preço, Servico serviço) {
        this.tipo = tipo;
        this.preço = preço;
        this.serviço = serviço;
    }

    public String toString()
    {
        String saida ="";
        
        if(this.peça!=null)
        {
            saida += "Tipo: "+this.tipo+"\n";
            saida += "Preço: "+this.preço+"\n";
            saida += "Quantidade: "+this.qtde+"\n";
            saida += this.peça.toString()+"\n";
        }
        else
        {
            saida += "Tipo: "+this.tipo+"\n";
            saida += "Preço: "+this.preço+"\n";
            saida += this.serviço.toString()+"\n";
        }
        return saida;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Peca getPeça() {
        return peça;
    }

    public void setPeça(Peca peça) {
        this.peça = peça;
    }
       
}
