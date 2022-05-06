package menus;

public class MenuPrincipal extends Menu{

    public static int exibir()
    {
        String mensagem = "";
        
        mensagem += "1 - Gerenciar clientes\n";
        mensagem += "2 - Gerenciar peças\n";
        mensagem += "3 - Gerenciar serviços\n";
        mensagem += "4 - Gerenciar ordens de serviço\n";
        mensagem += "5 - Consultar total vendido em um período\n";
        mensagem += "6 - Sair do programa\n";
        
        return menuOpcoesNumeradas("Menu Principal", mensagem, 6);
    }
}
