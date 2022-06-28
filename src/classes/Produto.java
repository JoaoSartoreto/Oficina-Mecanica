package classes;

import excecoes.CampoVazioException;
import excecoes.produto.PrecoInvalidoException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import oficina.Oficina;

public abstract class Produto implements Serializable, Comparable {
    private int codigo;
    private String descricao;
    private double preco;

    public Produto(String descricao, double preco) throws PrecoInvalidoException, CampoVazioException {
        if (preco < 0) throw new PrecoInvalidoException();
        
        setDescricao(descricao);
        Oficina.contadorProdutos++;
        this.codigo = Oficina.contadorProdutos;
        this.preco = preco;
    }
    
    /* -- GETTERS E SETTERS -- */
    
    /* codigo */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /* descricao */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws CampoVazioException {
        if (descricao == null || descricao.isBlank()) throw new CampoVazioException("Descrição");
        this.descricao = descricao;
    }
    
    /* preco */
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws PrecoInvalidoException {
        if (preco < 0) throw new PrecoInvalidoException();
        this.preco = preco;
    }
    
    /* -- OUTROS MÉTODOS -- */
    
    /*
    Um toString comum, a única diferença é o uso de um formatador para o preço.
    */
    @Override
    public String toString()
    {
        String saida="";
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        
        saida += "Código: " + this.codigo + "\n";
        saida += "Descrição: " + this.descricao + "\n";
        saida += "Preco Unitário: " + formatador.format(this.preco) + "\n";
        
        return saida;
    }
    

}
