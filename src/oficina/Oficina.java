package oficina;
import java.util.ArrayList;

import classes.Cliente;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import menus.MenuClientes;
import menus.MenuOS;
import menus.MenuPecas;
import menus.MenuPrincipal;
import menus.MenuServicos;

public class Oficina {

    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private static ArrayList<OrdemServico> listaOS = new ArrayList<OrdemServico>();
    private static ArrayList<Peca> listaPecas = new ArrayList<Peca>();
    private static ArrayList<Servico> listaServicos = new ArrayList<Servico>();

    // MAIN

    public static void main(String[] args) {
        boolean sair = false;

        do {
            int opcao = MenuPrincipal.exibir();
            switch (opcao) {
                case 1:
                    gerenciarClientes();
                    break;
            
                case 2:
                    opcao = MenuPecas.exibir();
                    break;

                case 3:
                    opcao = MenuServicos.exibir();
                    break;

                case 4:
                    gerenciarOS();
                    break;

                case 5:
                    
                    break;
                
                // Ao fechar a janela ou selecionar a opção 6
                default:
                    sair = true;
                    break;
            }
        } while (!sair);
    }

    // OUTROS MÉTODOS

    // Percorre a lista de clientes verificando o CPF dos clientes.
    // Se algum cliente possuir o CPF igual ao passado por parâmetro devolve true, senão devolve false.
    public static boolean isCpfCadastrado(String cpf)
    {
        for (Cliente cliente : listaClientes) 
            if (cliente.getCpf() == cpf) return true;

        return false;
    }

    // Chama os menus e diálogos relacionadas ao gerenciamento de clientes de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de clientes.
    private static void gerenciarClientes()
    {
        boolean sair = false;

        do {
            int opcao = MenuClientes.exibir();
            switch (opcao) {
                case 1:
                    Cliente cliente = MenuClientes.exibirCadastroCliente();
                    if (cliente != null) listaClientes.add(cliente);
                    System.out.println(cliente);
                    break;
            
                default:
                    sair = true;
                    break;
            }
        } while (!sair);
    }

    // Chama os menus e diálogos relacionadas ao gerenciamento de OS de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de OS.
    private static void gerenciarOS()
    {
        int opcao = MenuOS.exibir();

        switch (opcao) {
            case 2: 
                opcao = MenuOS.gerenciarItens();
                break;
        }
    }

}
