package menus;

public abstract class MenuItem extends Menu{

    protected static int exibir(String tipoItem)
    {
        String mensagem = "";
        
        mensagem += "1 - Cadastrar\n";
        mensagem += "2 - Consultar por código\n";
        mensagem += "3 - Excluir\n";
        mensagem += "4 - Editar\n";
        mensagem += "5 - Listar todos os cadastros\n";
        mensagem += "6 - Voltar";
        
        return menuOpcoesNumeradas("Gerenciar " + tipoItem, mensagem, 6);
    }
}
