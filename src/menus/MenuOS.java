package menus;

import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import java.util.ArrayList;

public class MenuOS {

    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de ordem de serviço.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        String mensagem= "";
        
        mensagem += "1 - Abrir nova ordem de serviço\n";
        mensagem += "2 - Gerenciar itens\n";
        mensagem += "3 - Cancelar\n";
        mensagem += "4 - Finalizar\n";
        mensagem += "5 - Excluir\n";
        mensagem += "6 - Listar todas as ordens\n";
        mensagem += "7 - Voltar";
        
        return Menu.exibirMenuNumerado("Gerenciar Ordens de Serviço", mensagem, 7);
    }

    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de itens de OS.
    // Devolve a opção selecionada (int).
    public static int gerenciarItens() {
        String mensagem = "";
        
        mensagem +="1 - Adicionar peça\n";
        mensagem +="2 - Adicionar serviço\n";
        mensagem +="3 - Excluir peça\n";
        mensagem +="4 - Excluir serviço\n";
        mensagem +="5 - Consultar total\n";
        mensagem +="6 - Voltar";
        
        return Menu.exibirMenuNumerado("Gerenciar Itens de OS", mensagem, 6);
    }
    
    public static OrdemServico adicionarOS()
    {
        String titulo = "Abir Ordem de Serviço";
        String dataPrevTermino;
        String placaCarro;
        
        dataPrevTermino = Menu.exibirDialogoEntrada(titulo,"Data prevista para o termino: ");
        placaCarro = Menu.exibirDialogoEntrada(titulo, "Placa do carro: ");
        
        OrdemServico ordemOS = new OrdemServico(dataPrevTermino,placaCarro);
        return ordemOS;
    }
    
    public static void cancelarOS (ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Cancelamento de OS";
        int index;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o index da OS que deseja excluir: ")); 
        ordensOS.get(index).cancelarOS();
        Menu.imprimeString(titulo,"Cancelado com sucesso");
    }
    
    public static void finalizarOS(ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Finalização de OS";
        int index;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o index da OS que deseja excluir: "));        
        ordensOS.get(index).finalizarOS();
        Menu.imprimeString(titulo, "Ordem de serviço finalizada com sucesso");
    }
    
    public static void excluirOS(ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Exclusão de OS";
        int index;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o index da OS que deseja excluir: "));
        ordensOS.remove(index);
        Menu.imprimeString(titulo, "Ordem de serviço excluida com sucesso");
    }
    
    public static void listarOSs(ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Listagem de OS";
        String saida="";
        for (OrdemServico ordemServico : ordensOS) {
            saida += ordemServico.toString();
        }
        Menu.imprimeString(titulo, saida);
    }
    
    
    //GERENCIAR ITENS
    
    public static void adicionarPeca(Peca peca, OrdemServico ordemOS)
    {
        String titulo = "Adicionar peça a OS";
        double preço;
        int quantidade;
        
        preço = Double.parseDouble(Menu.exibirDialogoEntrada(titulo, "Preço: "));
        quantidade = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Quantidade: "));
        
        ordemOS.adicionarPeca('P', preço, quantidade, peca);
        Menu.imprimeString(titulo, "Peça adicionada com sucesso");
    }
    
    public static void adicionarServico(Servico servico, OrdemServico ordemOS)
    {
       String titulo = "Adicionar Serviço  a OS";
       double preço;
       int quantidade; 
       
       preço = Double.parseDouble(Menu.exibirDialogoEntrada(titulo, "Preço: "));
       quantidade = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Quantidade: "));
        
        ordemOS.adicionarServico('S', preço, quantidade, servico);
        Menu.imprimeString(titulo, "Serviço adicionado com sucesso");
    }

    public static void excluirPeca(ArrayList<Peca> pecas)
    {
        String titulo = "Exclusão de Peça da OS";
        int index;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o index da peça que deseja excluir"));
        pecas.remove(index);
        Menu.imprimeString(titulo, "Peça excluida com sucesso");
    }
    
    public static void excluirServico(ArrayList<Servico> servicos)
    {
        String titulo = "Exclusão de Peça da OS";
        int index;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o index do serviço que deseja excluir"));
        servicos.remove(index);
        Menu.imprimeString(titulo, "Serviço excluido com sucesso");
    }
    
    public static void consultarTotalOS(ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Consulta de total da OS";
        int index;
        double total;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o index da OS que deseja ver o total:"));
        total = ordensOS.get(index).valorOS();
        Menu.imprimeString(titulo, "Valor total é: "+total);
    }
}
