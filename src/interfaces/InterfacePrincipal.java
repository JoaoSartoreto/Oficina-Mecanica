package interfaces;

public class InterfacePrincipal {

    // Chama o método exibirMenuNumerado para exibir o menu principal.
    // Devolve a opção selecionada (int).
    public static int exibir()
    {
        String mensagem = "";
        
        mensagem += "1 - Gerenciar clientes\n";
        mensagem += "2 - Gerenciar peças\n";
        mensagem += "3 - Gerenciar serviços\n";
        mensagem += "4 - Gerenciar ordens de serviço\n";
        mensagem += "5 - Consultar total vendido em um período\n";
        mensagem += "6 - Sair do programa\n";
        
        return Interface.exibirMenu("Menu Principal", mensagem, 6);
    }
}
