package classes;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrdemServico {
    private static int qtde;
    
    private int numeroOS;
    private LocalDate dataOS;
    private LocalDate dataPrevTermino;
    private LocalDate dataTermino;
    private String placaCarro;
    private char situacao;
    private ArrayList<ItemOS> itensOS;
    private Cliente cliente;

    public OrdemServico(String dataPrevTermino, String placaCarro, Cliente cliente) {
        // O número das ordens de serviço será de acordo com a ordem de criação
        
        OrdemServico.qtde++;
        this.numeroOS = OrdemServico.qtde;
        this.dataOS = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        this.dataPrevTermino = LocalDate.parse(dataPrevTermino, formato);
        this.placaCarro = placaCarro;
        this.situacao = 'A';
        this.itensOS = new ArrayList<>();
        this.cliente = cliente;
    }
    
    // GETTERS E SETTERS
    
    // numeroOS
    public int getNumeroOS() {
        return numeroOS;
    }

    // dataOS
    public LocalDate getDataOS() {
        return dataOS;
    }

    // dataPrevTermino
    public LocalDate getDataPrevTermino() {
        return dataPrevTermino;
    }

    public void setDataPrevTermino(LocalDate dataPrevTermino) {
        this.dataPrevTermino = dataPrevTermino;
    }

    // dataTermino  
    public LocalDate getDataTermino() {
        return dataTermino;
    }

    // placaCarro
    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    // situacao
    public char getSituação() {
        return situacao;
    }

    // itensOS
    public ArrayList<ItemOS> getItensOS() {
        return itensOS;
    }
    
    //cliente
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // OUTROS MÉTODOS

    // Se a OS estiver aberta adiciona um ItemOS de serviço à lista de itens.
    // Devolve um boolean representando o sucesso da operação.
    public boolean adicionarServico(int qtde, Servico servico) {
        if (situacao == 'A') {
            ItemOS itemOS = new ItemOS(qtde, servico);
            this.itensOS.add(itemOS);
            return true;
        }
        
        return false; 
    }
    
    // Se a OS estiver aberta e haver quantidade da peça suficiente no estoque adiciona um ItemOS da peça à lista de itens.
    // Devolve um boolean representando o sucesso da operação.
    public boolean adicionarPeca(int qtde, Peca peca) {
        if (situacao == 'A') {
            if (peca.subtrairEstoque(qtde)) {
                ItemOS itemOS = new ItemOS(qtde , peca);
                this.itensOS.add(itemOS);
                return true;
            }
        }
        
        return false;
    }

    // Remove um itemOS, devolvendo as peças, se a OS estiver aberta.
    // Devolve um boolean representando o sucesso da operação.
    public boolean removerItemOSPeca(int codigo) {      
        if (situacao == 'A')
            for (ItemOS itemOS : itensOS) 
                if (itemOS.getTipo() == 'P' && itemOS.getPeca().getCodPeca() == codigo) {
                    itemOS.devolver();
                    itensOS.remove(itemOS);
                    return true;
                }

        return false;
    }
    
    // Remove um itemOS, devolvendo as peças, se a OS estiver aberta.
    // Devolve um boolean representando o sucesso da operação.
    public boolean removerItemOSServico(int codigo) {      
        if (situacao == 'A')
            for (ItemOS itemOS : itensOS) 
                if (itemOS.getTipo() == 'S' && itemOS.getServico().getCodServico() == codigo) {
                    itensOS.remove(itemOS);
                    return true;
                }

        return false;
    }
    
    // Se a OS estiver aberta percorre a lista de itens devolvendo as peças, altera a situação para C (Cancelada)
    // e coloca a data de término com a data atual.
    // Devolve um boolean representando o sucesso da operação.
    public boolean cancelarOS() {
        if (situacao == 'A') {
            // Percorre todas os itemOS devolvendo as peças
            for (ItemOS itemOS : itensOS) itemOS.devolver();

            this.situacao = 'C';
            this.dataTermino = LocalDate.now();
            return true;
        }
        
        return false;
    }
    
    // Se a OS estiver aberta altera a situação para F (Finalizada) e coloca a data de término com a data atual.
    // Devolve um boolean representando o sucesso da operação.
    public boolean finalizarOS() {   
        if (situacao == 'A') {
            this.situacao = 'F';
            this.dataTermino = LocalDate.now();
            return true;
        }
        
        return false;
    }
    
    public String consultarTotal() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String saida = "";
        
        saida += "Total: " + formatador.format(getValorOS()) +"\n\n";
        saida += listaItensOS();
        
        return saida;
    }
    
    // Percorre a lista de itens chamando o método toString() para formar uma string com a lista dos itens.
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
    
    // Percorre a lista de itens e retorna a soma de todos os itens
    public double getValorOS() {
        double total = 0;
        
        for (ItemOS itemOS : itensOS)
            total += (itemOS.getPreco() * itemOS.getQtde());
    
        return total;
    }

    @Override
    public String toString()
    {
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String saida = "";
        
        saida += "Número OS: " + numeroOS + "\n";
        saida += "Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")\n";
        saida += "Data: " + dataOS.format(formatadorData) + "\n";
        saida += "Data prevista para termino: " + dataPrevTermino.format(formatadorData) + "\n";
        saida += "Data termino: " + (dataTermino == null ? "Em aberto" : dataTermino.format(formatadorData)) + "\n";
        saida += "Placa do carro: " + placaCarro + "\n";
        saida += "Situação: " + situacao + "\n";
        saida += "Valor: " + formatadorMoeda.format(getValorOS() + "\n");

        return saida;
    }

}
