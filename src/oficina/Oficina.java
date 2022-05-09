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
        int opcao;
        
        do {
            opcao = InterfacePrincipal.exibir();
            switch (opcao) {
                case 1 -> gerenciarClientes();
                case 2 -> opcao = InterfacePecas.exibir();
                case 3 -> gerenciarServicos();
                case 4 -> gerenciarOS();
                case 5 -> {
                }
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }

    // OUTROS MÉTODOS
    
    // MÉTODOS RELACIONADOS AOS CLIENTES
    
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    // Percorre a lista de clientes verificando o CPF dos clientes.
    // Se encontrar um cliente com CPF correspondente ele é devolvido, senão é devolvido null.
    public static Cliente buscarCliente(String cpf) {
        for (Cliente cliente : listaClientes) 
            if (cliente.getCpf().equals(cpf)) return cliente;

        return null;
    }
    
    // Busca um cliente pelo CPF e o remove da lista.
    // Devolve um boolean representando o sucesso da operação. 
    public static boolean excluirCliente(String cpf) {
        return listaClientes.remove(buscarCliente(cpf));
    }

    // Chama os menus e diálogos relacionadas ao gerenciamento de clientes de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de clientes.
    private static void gerenciarClientes() {
        int opcao;

        do {
            opcao = InterfaceClientes.exibir();
            switch (opcao) {
                case 1 -> {
                    Cliente cliente = InterfaceClientes.exibirCadastroCliente();
                    if (cliente != null) listaClientes.add(cliente);
                }
                
                case 2 -> InterfaceClientes.exibirConsultarCpf();
                case 3 -> InterfaceClientes.exibirExcluirCliente();
                case 4 -> InterfaceClientes.exibirEditarCliente();
                case 5 -> InterfaceClientes.exibirListarClientes();  
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    // MÉTODOS RELACIONADOS AOS SERVIÇOS
    
    // Percorre a lista de serviços verificando os códigos.
    // Se encontrar um serviço com código correspondente ele é devolvido, senão é devolvido null.
    public static Servico buscarServico(int codigo) {
        for (Servico servico : listaServicos) 
            if (servico.getCodServico() == codigo) return servico;

        return null;
    }
    
    // Busca um serviço pelo código e o remove da lista.
    // Devolve um boolean representando o sucesso da operação. 
    public static boolean excluirServico(int codigo) {
        return listaServicos.remove(buscarServico(codigo));
    }
    
    // Chama os menus e diálogos relacionadas ao gerenciamento de serviços de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de serviços.
    private static void gerenciarServicos() {
        int opcao;

        do {
            opcao = InterfaceServicos.exibir();
            switch (opcao) {
                case 1 -> {
                    Servico servico = InterfaceServicos.exibirCadastroServico();
                    if (servico != null) listaServicos.add(servico);
                }
                
                case 2 -> InterfaceServicos.exibirConsultaCodigo();
                case 3 -> InterfaceServicos.exibirExcluirServico();
                case 4 -> InterfaceServicos.exibirEditarServico();
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    // MÉTODOS RELACIONADOS À OS
    
    // Chama os menus e diálogos relacionadas ao gerenciamento de OS de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de OS.
    private static void gerenciarOS() {
        int opcao = InterfaceOS.exibir();

        switch (opcao) {
            case 2 -> opcao = InterfaceOS.exibirGerenciarItens();
        }
    }

}
