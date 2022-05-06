package menus;

public class MenuClientes extends Menu{
    
    public static int exibir()
    {
        String mensagem = "";
        
        mensagem += "1 - Cadastrar\n";
        mensagem += "2 - Consultar por CPF\n";
        mensagem += "3 - Excluir\n";
        mensagem += "4 - Editar\n";
        mensagem += "5 - Listar todos os cadastros\n";
        mensagem += "6 - Voltar\n";
        
        return menuOpcoesNumeradas("Gerenciar Clientes", mensagem, 6);
    }
}