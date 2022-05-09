package oficina;
import java.util.ArrayList;

import classes.Cliente;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import interfaces.InterfaceClientes;
import interfaces.InterfaceOS;
import interfaces.InterfacePecas;
import interfaces.InterfacePrincipal;
import interfaces.InterfaceServicos;

public class Oficina {

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ArrayList<OrdemServico> listaOS = new ArrayList<>();
    private static ArrayList<Peca> listaPecas = new ArrayList<>();
    private static ArrayList<Servico> listaServicos = new ArrayList<>();

    // MAIN
    public static void main(String[] args) {
        boolean sair = false;

        do {
            int opcao = InterfacePrincipal.exibir();
            switch (opcao) {
                case 1 -> gerenciarClientes();
            
                case 2 -> opcao = InterfacePecas.exibir();

                case 3 -> opcao = InterfaceServicos.exibir();

                case 4 -> gerenciarOS();

                case 5 -> {
                }
                default -> sair = true;
            }
            // Ao fechar a janela ou selecionar a opção 6
                    } while (!sair);
    }

    // OUTROS MÉTODOS

    // Percorre a lista de clientes verificando o CPF dos clientes.
    // Se encontrar um cliente com CPF correspondente ele é devolvido, senão é devolvido null.
    public static Cliente buscarCliente(String cpf)
    {
        for (Cliente cliente : listaClientes) 
            if (cliente.getCpf().equals(cpf)) return cliente;

        return null;
    }

    // Chama os menus e diálogos relacionadas ao gerenciamento de clientes de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de clientes.
    private static void gerenciarClientes()
    {
        boolean sair = false;

        do {
            int opcao = InterfaceClientes.exibir();
            switch (opcao) {
                case 1 -> {
                    Cliente cliente = InterfaceClientes.exibirCadastroCliente();
                    if (cliente != null) listaClientes.add(cliente);
                }
                
                case 2 -> {
                    InterfaceClientes.exibirConsultaCpf();
                }
            
                default -> sair = true;
            }
        } while (!sair);
    }

    // Chama os menus e diálogos relacionadas ao gerenciamento de OS de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de OS.
    private static void gerenciarOS()
    {
        int opcao = InterfaceOS.exibir();

        switch (opcao) {
            case 2 -> opcao = InterfaceOS.exibirGerenciarItens();
        }
    }

}
