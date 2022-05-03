/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1poo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author joovitor
 */
public class OrdemServiço {
    private int numeroOS;
    private LocalDate data;
    private LocalDate dataPrevTermino;
    private LocalDate dataTermino;
    private String placaCarro;
    private char situação;
    private ArrayList<ItemOS> itensOS;
    private static int qtd;

    public OrdemServiço(String dataPrevTermino, String dataTermino, String placaCarro, char situação) {
        //o ID da ordem de serviço, se dará pela posição em que ele foi criado
        this.numeroOS = this.qtd;
        this.qtd++;
        this.data = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataPrevTermino = LocalDate.parse(dataPrevTermino,formato);
        this.dataTermino = LocalDate.parse(dataTermino,formato);
        this.placaCarro = placaCarro;
        this.situação = situação;
        this.itensOS = new ArrayList<ItemOS>();
    }
    
    
    public void adicionarServico(char tipo, double preço, Serviço serviço)
    {
        ItemOS itemOS = new ItemOS(tipo,preço,serviço);
        this.itensOS.add(itemOS);
    }
    
    public boolean adicionarPeca(char tipo, double preço, int qtd, Peça peça)
    {
        if(peça.subPeca(qtd))
        {
            ItemOS itemOS = new ItemOS(tipo,preço,qtd,peça);
            this.itensOS.add(itemOS);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void removerServiço(int index)
    {
        this.itensOS.remove(index);
    }
    
    public void removerPeça(int index)
    {
        itensOS.get(index).getPeça().addPeca(itensOS.get(index).getQtde());
        this.itensOS.remove(index);          
    }
    
    public String toString()
    {
        String saida="";
        
        saida += "Numero OS: "+this.numeroOS+"\n";
        saida += "Data: "+this.data+"\n";
        saida += "Data prevista para termino: "+this.dataPrevTermino+"\n";
        saida += "Data termino: "+this.dataTermino+"\n";
        saida += "Placa do carro: "+this.placaCarro+"\n";
        saida += "Situação: "+situação+"\n";
        saida += "Itens: "+"\n";
        for (ItemOS itemOS : itensOS) {
            saida += itemOS.toString();
        }   
        return saida;
    }
    
    public void cancelarOS()
    {
        //percorre todas as peças
        for (ItemOS itemOS : itensOS) {
            if(itemOS.getTipo()=='P')
            {
                // na variavel qtdEstoque, referente a peça, a quantidade de peças que forem 
                // retiradas serão devolvidas para o estoque de volta
                itemOS.getPeça().addPeca(itemOS.getQtde());
            }
        }
        this.situação = 'C';
        itensOS.clear();
    }
    
    public void finalizarOS()
    {
        this.situação = 'F';
    }
    
    public String listaItemOS()
    {
        String saida="";
        int index = 0;
        
        for (ItemOS itemOS : itensOS) {
            saida += "Index: "+index+"\n";
            saida += itemOS.toString()+"\n";
            index++;
        }
        
        return saida;
    }

    public int getNumeroOS() {
        return numeroOS;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalDate getDataPrevTermino() {
        return dataPrevTermino;
    }

    public void setDataPrevTermino(LocalDate dataPrevTermino) {
        this.dataPrevTermino = dataPrevTermino;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public char getSituação() {
        return situação;
    }

    public ArrayList<ItemOS> getItensOS() {
        return itensOS;
    }

    
}
