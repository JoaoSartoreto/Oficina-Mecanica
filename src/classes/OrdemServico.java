package classes;

import excecoes.CampoVazioException;
import excecoes.itemos.AdicionarItemOSNaoAbertaException;
import excecoes.DataInvalidaException;
import excecoes.os.OSNaoAbertaException;
import excecoes.produto.peca.EstoqueInsuficienteException;
import excecoes.itemos.ItemNaoEncontradoException;
import excecoes.QuantidadeInvalidaException;
import excecoes.itemos.RemoverItemOSNaoAbertaException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import oficina.Oficina;

public class OrdemServico implements Serializable{
    private int numeroOS;
    private LocalDate dataOS;
    private LocalDate dataPrevTermino;
    private LocalDate dataTermino;
    private String placaCarro;
    private char situacao;
    private ArrayList<ItemOS> itensOS;
    private Cliente cliente;

    public OrdemServico(String dataPrevTermino, String placaCarro, Cliente cliente) throws DataInvalidaException, CampoVazioException {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate parsedDataPrevTermino = LocalDate.parse(dataPrevTermino, formato);
        LocalDate now = LocalDate.now();
        if(parsedDataPrevTermino.isBefore(now)) throw new DataInvalidaException();
        
        setPlacaCarro(placaCarro);
        
        Oficina.contadorOS++;
        this.numeroOS = Oficina.contadorOS;
        this.dataOS = now;
        this.dataPrevTermino = parsedDataPrevTermino;
        
        this.situacao = 'A';
        this.itensOS = new ArrayList<>();
        this.cliente = cliente;
    }
    
    /* -- GETTERS E SETTERS */
    
    /* numeroOS */
    public int getNumeroOS() {
        return numeroOS;
    }

    /* dataOS */
    public LocalDate getDataOS() {
        return dataOS;
    }

    /* dataPrevTermino */
    public LocalDate getDataPrevTermino() {
        return dataPrevTermino;
    }

    public void setDataPrevTermino(LocalDate dataPrevTermino) {
        this.dataPrevTermino = dataPrevTermino;
    }

    /* dataTermino */ 
    public LocalDate getDataTermino() {
        return dataTermino;
    }

    /* placaCarro */
    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) throws CampoVazioException {
        if (placaCarro == null || placaCarro.isBlank()) throw new CampoVazioException("Placa do Veículo");
        this.placaCarro = placaCarro;
    }

    /* situacao */
    public char getSituacao() {
        return situacao;
    }

    /* itensOS */
    public ArrayList<ItemOS> getItensOS() {
        return itensOS;
    }
    
    /* cliente */
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /* -- OUTROS MÉTODOS -- */

    /*
    Se a OS estiver aberta adiciona um ItemOS de serviço à lista de itens,
    senão lança uma AdicionarItemOSNaoAbertaException.
    Se a quantidade for inválida também é lançada uma exceção.
    */
    public void adicionarServico(int qtde, Servico servico) throws AdicionarItemOSNaoAbertaException, QuantidadeInvalidaException {
        if (qtde <= 0) throw new QuantidadeInvalidaException();
        if (situacao == 'A') {
            ItemOS itemOS = new ItemOS(qtde, servico);
            this.itensOS.add(itemOS);
        }
        else
        {
            throw new AdicionarItemOSNaoAbertaException();
        }
        
    }
    
    /*
    Se a OS estiver aberta e haver quantidade da peça suficiente no estoque 
    adiciona um ItemOS da peça à lista de itens, senão é lançada uma exceção especifica do problema.
    Se a quantidade for inválida também é lançada uma exceção.
    */
    public void adicionarPeca(int qtde, Peca peca) throws AdicionarItemOSNaoAbertaException, QuantidadeInvalidaException, EstoqueInsuficienteException {
        if (situacao == 'A') {
            peca.subtrairEstoque(qtde);
            ItemOS itemOS = new ItemOS(qtde , peca);
            this.itensOS.add(itemOS);
        }
        else
        {
            throw new AdicionarItemOSNaoAbertaException();
        }
        
    }

    /*
    Se a OS estiver aberta percorre a lista de itens procurando um item que seja uma peça e 
    que tenha o código correspodente, se encontrar o item sua quantidade é devolvida ao estoque
    e o item é removido da lista.
    Se houver algum problema é lançada uma exceção correspondente.
    */
    public void removerItemOSPeca(int codigo) throws RemoverItemOSNaoAbertaException, ItemNaoEncontradoException {      
        boolean removido = false;
        if (situacao == 'A') {
            Iterator<ItemOS> iterator = itensOS.iterator();
            while(iterator.hasNext()) {
                ItemOS itemOS = iterator.next();
                if (itemOS.getTipo() == 'P' && itemOS.getProduto().getCodigo() == codigo) {
                    itemOS.devolver();
                    iterator.remove();
                    removido = true;
                }
            }
            
            if (!removido) throw new ItemNaoEncontradoException();
        }
        else
        {
            throw new RemoverItemOSNaoAbertaException();
        }
    }
    
    /*
    Se a OS estiver aberta percorre a lista de itens procurando um item que seja um serviço e 
    que tenha o código correspodente, se encontrar o item ele é removido da lista.
    Se houver algum problema é lançada uma exceção correspondente.
    */
    public void removerItemOSServico(int codigo) throws RemoverItemOSNaoAbertaException, ItemNaoEncontradoException {
        boolean removido;
        if (situacao == 'A') {
            removido = itensOS.removeIf((ItemOS itemOS) -> itemOS.getTipo() == 'S' && itemOS.getProduto().getCodigo() == codigo);
            if (!removido) throw new ItemNaoEncontradoException();
        }
        else {
            throw new RemoverItemOSNaoAbertaException();
        }
    }
    
    /*
    Se a OS estiver aberta percorre a lista de itens devolvendo as peças, altera a situação para C (Cancelada)
    e coloca a data de término com a data atual.
    Se houver algum problema é lançada uma exceção correspondente.
    */
    public void cancelarOS() throws OSNaoAbertaException {
        if (situacao == 'A') {
            // Percorre todas os itemOS devolvendo as peças
            for (ItemOS itemOS : itensOS) itemOS.devolver();

            this.situacao = 'C';
            this.dataTermino = LocalDate.now();
        }
        else
        {
            throw new OSNaoAbertaException();
        }
    }
    
    /*
    Se a OS estiver aberta  altera a situação para F (Finalizada) e coloca a data de término com a data atual.
    Se houver algum problema é lançada uma exceção correspondente.
    */
    public boolean finalizarOS() throws OSNaoAbertaException {   
        if (situacao == 'A') {
            this.situacao = 'F';
            this.dataTermino = LocalDate.now();
            return true;
        }
        else
        {
            throw new OSNaoAbertaException();
        }
    }
    
    /*
    Chama getValorOS() e listaItensOS() para concatenar o valor total da OS com sua lista de itens.
    O método utiliza um formatador para o valor total e devolve uma String.
    */
    public String consultarTotal() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String saida = "";
        
        saida += "Total: " + formatador.format(getValorOS()) +"\n\n";
        saida += listaItensOS();
        
        return saida;
    }
    
    /*
    Percorre a lista de itens chamando o método toString() para formar uma string com a lista dos itens.
    */
    public String listaItensOS()
    {
        String saida="";
        int indice = 0;
        
        for (ItemOS itemOS : itensOS) {
            saida += "Índice: "+ indice + "\n";
            saida += itemOS.toString() + "\n";
            indice++;
        }
        
        return saida;
    }
    
    /*
    Percorre a lista de itens adicionando ao valor total da OS o produto do preço de cada item pela
    sua respectiva quantidade.
    Devolve um double contendo o valor total da OS.
    */
    public double getValorOS() {
        double total = 0;
        
        for (ItemOS itemOS : itensOS)
            total += (itemOS.getPreco());
    
        return total;
    }

    /*
    Um toString comum, a única diferença é o uso de formatadores.
    */
    @Override
    public String toString()
    {
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String saida = "";
        
        saida += "Número OS: " + numeroOS + "\n";
        saida += "Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")\n";
        saida += "Data: " + dataOS.format(formatadorData) + "\n";
        saida += "Data prevista para término: " + dataPrevTermino.format(formatadorData) + "\n";
        saida += "Data de término: " + (dataTermino == null ? "Em aberto" : dataTermino.format(formatadorData)) + "\n";
        saida += "Placa do carro: " + placaCarro + "\n";
        saida += "Situação: " + situacao + "\n";
        saida += "Valor: " + formatadorMoeda.format(this.getValorOS())+"\n";

        return saida;
    }

}
