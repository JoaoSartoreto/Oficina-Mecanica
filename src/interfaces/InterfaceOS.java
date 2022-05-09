package interfaces;

import classes.ItemOS;
import classes.OrdemServico;
import classes.Servico;
import java.util.ArrayList;

public class InterfaceOS {

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
        
        return Interface.exibirMenuNumerado("Gerenciar OS", mensagem, 7);
    }
    
    public static OrdemServico exibirAbrirOS()
    {
        String titulo = "Abir OS";
        String dataPrevTermino;
        String placaCarro;
        
        dataPrevTermino = Interface.exibirDialogoEntrada(titulo, "Data prevista para o término: ");
        if (dataPrevTermino == null) return null;
        
        placaCarro = Interface.exibirDialogoEntrada(titulo, "Placa do carro: ");
        if (placaCarro == null) return null;
        
        return new OrdemServico(dataPrevTermino, placaCarro);
    }
    
    public static int exibirCancelarOS ()
    {
        return Integer.parseInt(Interface.exibirDialogoEntrada("Cancelar OS", "Insira o índice da OS que deseja cancelar: ")); 
    }
    
    public static int exibirFinalizarOS()
    {
        return Integer.parseInt(Interface.exibirDialogoEntrada("Finalizar OS", "Insira o índice da OS que deseja finalizar: "));        
    }
    
    public static int exibirExcluirOS()
    {
        return Integer.parseInt(Interface.exibirDialogoEntrada("Excluir OS", "Insira o índice da OS que deseja excluir: "));
    }
    
    public static void exibirListaOS(ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Listar Ordens de Serviço";
        String saida= "";
        
        for (OrdemServico ordemServico : ordensOS)
            saida += ordemServico.toString();
        
        Interface.exibirMensagem(titulo, saida);
    }

    // GERENCIAR ITENS
    
    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de itens de OS.
    // Devolve a opção selecionada (int).
    public static int exibirGerenciarItens() {
        String mensagem = "";
        
        mensagem += "1 - Adicionar peça\n";
        mensagem += "2 - Adicionar serviço\n";
        mensagem += "3 - Excluir peça\n";
        mensagem += "4 - Excluir serviço\n";
        mensagem += "5 - Consultar total\n";
        mensagem += "6 - Voltar";
        
        return Interface.exibirMenuNumerado("Gerenciar Itens de OS", mensagem, 6);
    }
    
    // TODO método para selecionar OS
    // TODO método para selecionar peça
    
    public static ItemOS exibirAdicionarPeca()
    {
        String titulo = "Adicionar Peça a OS";
        String stringPreco;
        String stringQuantidade;
        double preco;
        int quantidade;
        
        stringPreco = Interface.exibirDialogoEntrada(titulo, "Preço: ");
        if (stringPreco == null)
            return null;
        else
            preco = Double.parseDouble(stringPreco);
            
        stringQuantidade = Interface.exibirDialogoEntrada(titulo, "Quantidade: ");
        if (stringQuantidade == null)
            return null;
        else
            quantidade = Integer.parseInt(stringQuantidade);
        
        // return new ItemOS('P', preço, quantidade, peca);
        return null;
    }
    
    // TODO método para selecionar serviço
    
    public static ItemOS exibirAdicionarServico(Servico servico, OrdemServico ordemOS) {
        String titulo = "Adicionar Serviço a OS";
        String stringPreco;
        String stringQuantidade;
        double preco;
        int quantidade; 

        stringPreco = Interface.exibirDialogoEntrada(titulo, "Preço: ");
        if (stringPreco == null)
            return null;
        else
            preco = Double.parseDouble(stringPreco);

        stringQuantidade = Interface.exibirDialogoEntrada(titulo, "Quantidade: ");
        if (stringQuantidade == null)
            return null;
        else
            quantidade = Integer.parseInt(stringQuantidade);
        
        // ordemOS.adicionarServico('S', preço, quantidade, servico);
        return null;
    }

    public static int exibirExcluirPeca()
    {
        return Integer.parseInt(Interface.exibirDialogoEntrada("Excluir Peça de OS", "Insira o índice da peça que deseja excluir"));
    }
    
    public static int excluirServico()
    {
        return Integer.parseInt(Interface.exibirDialogoEntrada("Excluir Serviço de OS", "Insira o índice da peça que deseja excluir"));
    }
    
    public static void consultarTotalOS()
    {
        // Aqui terá que passar uma String ou OS e mostrar o total dela;
    }
}
