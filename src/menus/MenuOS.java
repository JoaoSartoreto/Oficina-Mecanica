package menus;

public class MenuOS extends Menu{

    public static int exibir() {
        String mensagem= "";
        
        mensagem += "1 - Abrir nova ordem de serviço\n";
        mensagem += "2 - Gerenciar itens\n";
        mensagem += "3 - Cancelar\n";
        mensagem += "4 - Finalizar\n";
        mensagem += "5 - Excluir\n";
        mensagem += "6 - Listar todas as ordens\n";
        mensagem += "7 - Voltar";
        
        return menuOpcoesNumeradas("Gerenciar Ordens de Serviço", mensagem, 7);
    }

    public static int gerenciarItens() {
        String mensagem = "";
        
        mensagem +="1 - Adicionar peça\n";
        mensagem +="2 - Adicionar serviço\n";
        mensagem +="3 - Excluir peça\n";
        mensagem +="4 - Excluir serviço\n";
        mensagem +="5 - Consultar total\n";
        mensagem +="6 - Voltar";
        
        return menuOpcoesNumeradas("Gerenciar Itens de OS", mensagem, 6);
    }
}
