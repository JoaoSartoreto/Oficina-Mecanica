package menus;

public abstract class MenuItem {

    // Chama o método exibirMenuNumerado para exibir um menu de gerenciamento de Peca ou Servico.
    // O tipoItem é utilizado para formar o título.
    // Devolve a opção selecionada (int). 
    protected static int exibir(String tipoItem)
    {
        String mensagem = "";
        
        mensagem += "1 - Cadastrar\n";
        mensagem += "2 - Consultar por código\n";
        mensagem += "3 - Excluir\n";
        mensagem += "4 - Editar\n";
        mensagem += "5 - Listar todos os cadastros\n";
        mensagem += "6 - Voltar";
        
        return Menu.exibirMenuNumerado("Gerenciar " + tipoItem, mensagem, 6);
    }

}
