package oficina;
import java.util.ArrayList;

import classes.Cliente;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import interfaces.Interface;
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
            
                case 2 -> gerenciarPecas();

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
    
    //METODOS RELACIONADOS AS PEÇAS
    
    public static void gerenciarPecas()
    {
        boolean sair = false;

        do {
            int opcao = InterfacePecas.exibir();
            switch (opcao) {
                case 1 -> {
                    Peca peca = InterfacePecas.exibirCadastrarPeca();
                    if (peca != null) listaPecas.add(peca);
                }
                
                case 2 -> {
                    InterfacePecas.exibirConsultarPeca();
                }
                
                case 3 -> {
                    InterfacePecas.exibirExcluirPeca();
                }
                
                case 4 -> {
                    InterfacePecas.exibirEditarPeca();
                }
                
                case 5 -> {
                    InterfacePecas.listarPecas(listaPecas);
                }
            
                default -> sair = true;
            }
        } while (!sair);
    }
    
    public static Peca buscarPeca(int codPeca)
    {
        for (Peca peca : listaPecas) {
            if(peca.getCodPeca()==codPeca)
            {
                return peca;
            }
        }
        return null;
    }
    
    public static boolean excluirPeca(int index)
    {
        return listaPecas.remove(buscarPeca(index));
    }
    
    public static void editarPeca(int codPeca, String descricao, double preco, int qtdeEstoque)
    {
        listaPecas.get(codPeca).setDescricao(descricao);
        listaPecas.get(codPeca).setPreco(preco);
        listaPecas.get(codPeca).setDescricao(descricao);
    }
    
    //METODOS RELACIONADOS AOS SERVIÇOS
    
    public static Servico buscarServico(int codServico)
    {
        for (Servico servico : listaServicos) {
            if(servico.getCodServico() == codServico)
            {
                return servico;
            }
        }
        return null;
    }
    
    // MÉTODOS RELACIONADOS AOS CLIENTES
    
    // Percorre a lista de clientes verificando o CPF dos clientes.
    // Se encontrar um cliente com CPF correspondente ele é devolvido, senão é devolvido null.
    public static Cliente buscarCliente(String cpf)
    {
        for (Cliente cliente : listaClientes) 
            if (cliente.getCpf().equals(cpf)) return cliente;

        return null;
    }
    
    // Busca um cliente pelo CPF e remove da lista.
    // Devolve um boolean representando o sucesso da operação. 
    public static boolean excluirCliente(String cpf)
    {
        return listaClientes.remove(buscarCliente(cpf));
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
                
                case 3 -> {
                    InterfaceClientes.exibirExcluirCliente();
                }
            
                default -> sair = true;
            }
        } while (!sair);
    }
    
    // MÉTODOS RELACIONADOS À OS
    
    // Chama os menus e diálogos relacionadas ao gerenciamento de OS de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de OS.
    private static void gerenciarOS()
    {
        boolean sair = false;

        do {
            int opcao = InterfaceOS.exibir();
            switch (opcao) {
                case 1 -> {
                    OrdemServico ordemOS = InterfaceOS.exibirAbrirOS();
                    if (ordemOS != null) listaOS.add(ordemOS);
                }
                
                case 2 -> {
                    gerenciarItemOS();
                }
                
                case 3 -> {
                    InterfaceOS.exibirCancelarOS();
                }
                
                case 4 -> {
                    InterfaceOS.exibirFinalizarOS();
                }
                
                case 5 -> {
                    InterfaceOS.exibirExcluirOS();
                }
                
                case 6 -> {
                    InterfaceOS.exibirListaOS(listaOS);
                }
            
                default -> sair = true;
            }
        } while (!sair);
    }
    
    public static OrdemServico buscarOS(int numero)
    {
        for (OrdemServico ordemOS : listaOS) {
            if(ordemOS.getNumeroOS()==numero)
            {
                return ordemOS;
            }
        }
        return null;
    }
    
    public static void cancelarOS(OrdemServico ordemOS)
    {
        ordemOS.cancelarOS();
    }
    
    public static void finalizarOS(OrdemServico ordemOS)
    {
        ordemOS.finalizarOS();
    }
    
    public static void excluirOS(OrdemServico ordemOS)
    {
        listaOS.remove(ordemOS);
    }
    
    public static String listarOSs()
    {
        String saida="";
        for (int i = 0; i < listaOS.size();i++) {
            saida += listaOS.get(i).toString();
        }
        return saida;
    }
    
    // METODOS RELACIONADOS AOS ITEM OS
    
    private static void gerenciarItemOS()
    {
        boolean sair = false;

        do {
            int opcao = InterfaceOS.exibirGerenciarItens();
            switch (opcao) {
                case 1 -> {
                    InterfaceOS.exibirAdicionarPeca();
                }
                
                case 2 -> {
                    InterfaceOS.exibirAdicionarServico();
                }
                
                case 3 -> {
                    
                }
                
                case 4 -> {
                    
                }
                
                case 5 -> {
                    
                }
            
                default -> sair = true;
            }
        } while (!sair);
    }
    
    public static boolean adicionarItemOSPeca(int indexOS, Peca peca, int quantidade)
    {
        if(peca.subtrairEstoque(quantidade))
        {
            listaOS.get(indexOS).adicionarPeca('P', quantidade , peca);
            return true;
        }
        return false;
    }
    
    public static void adicionarItemOSServico(int indexOS, Servico servico, int quantidade)
    {
        listaOS.get(indexOS).adicionarServico('S', quantidade, servico);
    }

}
