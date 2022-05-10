package oficina;
import java.util.ArrayList;

import classes.Cliente;
import classes.ItemOS;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import interfaces.InterfaceClientes;
import interfaces.InterfaceOS;
import interfaces.InterfacePecas;
import interfaces.InterfacePrincipal;
import interfaces.InterfaceServicos;
import java.time.LocalDate;

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
                case 2 -> gerenciarPecas();
                case 3 -> gerenciarServicos();
                case 4 -> gerenciarOS();
                case 5 -> InterfacePrincipal.consultarTotalVendidoEmPeriodo();
                
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
    // Devolve um int representando o sucesso da operação ou especificando o erro. 
    public static int excluirCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        
        if (cliente == null) return 1;
        
        for (OrdemServico ordemServico : listaOS)
            if (ordemServico.getCliente() == cliente) return 2;
        
        listaClientes.remove(cliente);
        
        return 0;
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
    
    //METODOS RELACIONADOS AS PEÇAS
    
    public static ArrayList<Peca> getListaPecas() {
        return listaPecas;
    }
    
    public static Peca buscarPeca(int codPeca) {
        for (Peca peca : listaPecas)
            if(peca.getCodPeca() == codPeca) return peca;

        return null;
    }
    
    public static int excluirPeca(int codPeca) {
        Peca peca = buscarPeca(codPeca);
        
        if (peca == null) return 1;
        
        for (OrdemServico ordemServico : listaOS)
            for (ItemOS itemOS : ordemServico.getItensOS())
                if (itemOS.getPeca() == peca) return 2;
        
        listaPecas.remove(peca);
        
        return 0;
    }
    
    public static void editarPeca(int codPeca, String descricao, double preco, int qtdeEstoque) {
        listaPecas.get(codPeca).setDescricao(descricao);
        listaPecas.get(codPeca).setPreco(preco);
        listaPecas.get(codPeca).setDescricao(descricao);
    }
    
    public static void gerenciarPecas() {
        int opcao;
        
        do {
            opcao = InterfacePecas.exibir();
            switch (opcao) {
                case 1 -> {
                    Peca peca = InterfacePecas.exibirCadastrarPeca();
                    if (peca != null) listaPecas.add(peca);
                }
                case 2 -> InterfacePecas.exibirConsultarPeca();              
                case 3 -> InterfacePecas.exibirExcluirPeca();              
                case 4 -> InterfacePecas.exibirEditarPeca();               
                case 5 -> InterfacePecas.exibirListarPecas();
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    // MÉTODOS RELACIONADOS AOS SERVIÇOS
    
    public static ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }
    
    // Percorre a lista de serviços verificando os códigos.
    // Se encontrar um serviço com código correspondente ele é devolvido, senão é devolvido null.
    public static Servico buscarServico(int codServico) {
        for (Servico servico : listaServicos)
            if(servico.getCodServico() == codServico)
                return servico;
            
        return null;
    }
    
    // Busca um serviço pelo código e o remove da lista.
    // Devolve um boolean representando o sucesso da operação. 
    public static int excluirServico(int codServico) {
        Servico servico = buscarServico(codServico);
        
        if (servico == null) return 1;
        
        for (OrdemServico ordemServico : listaOS)
            for (ItemOS itemOS : ordemServico.getItensOS())
                if (itemOS.getServico() == servico) return 2;
        
        listaServicos.remove(servico);
        
        return 0;
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
                case 5 -> InterfaceServicos.exibirListarServicos();
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    // MÉTODOS RELACIONADOS À OS
    
    public static OrdemServico buscarOS(int numero) {
        for (OrdemServico ordemOS : listaOS)
            if(ordemOS.getNumeroOS() == numero)
                return ordemOS;
            
        return null;
    }
    
    public static void cancelarOS(OrdemServico ordemOS) {
        ordemOS.cancelarOS();
    }
        
    public static void finalizarOS(OrdemServico ordemOS) {
        ordemOS.finalizarOS();
    }
    
    public static int excluirOS(int numero) {
        OrdemServico ordemServico = buscarOS(numero);
        
        if (ordemServico == null) return 1;
        if (!ordemServico.cancelarOS()) return 2;
        
        listaOS.remove(ordemServico);
        return 0;
    }
    
    public static String listarOSs() {
        String saida="";
        for (int i = 0; i < listaOS.size();i++) {
            saida += listaOS.get(i).toString();
        }
        return saida;
    }
    
    //Uma ordem de serviço sempre é aberta sem valor nenhum, e seu valor é de acordo
    //com suas peças e serviços embutidos. Portanto antes de fazer a conversão do 
    //totalOS, retornado pelo proprio metodo da OrdemServico, é preciso verificar
    //se de fato é um numero, e não uma string vazia.
    public static String verificarTotalOS(OrdemServico ordemOS)
    {
        String totalString;
        double total = 0;
        totalString = ordemOS.valorOS();
        if(isNumeric(totalString))
        {
            total = Double.parseDouble(totalString);
        }
        
        String totalFinalString = ""+total;
        return totalFinalString;
    }
    
    // Chama os menus e diálogos relacionadas ao gerenciamento de OS de acordo com as opções selecionadas.
    // Também recebe os resultados desses métodos para manipular os elementos da lista de OS.
    private static void gerenciarOS() {
        int opcao;
        
        do {
            opcao = InterfaceOS.exibir();
            switch (opcao) {
                case 1 -> {
                    OrdemServico ordemServico = InterfaceOS.exibirAbrirOS();
                    if (ordemServico != null) listaOS.add(ordemServico);
                }  
                case 2 -> gerenciarItemOS();
                case 3 -> InterfaceOS.exibirCancelarOS();
                case 4 -> InterfaceOS.exibirFinalizarOS();
                case 5 -> InterfaceOS.exibirExcluirOS();
                case 6 -> InterfaceOS.exibirListaOS(listaOS);
            }
        } while (!(opcao == 0 || opcao == 7)); // Enquanto não fechar a janela ou selecionar a opção 7
    }
    
    // METODOS RELACIONADOS AOS ITENS OS
    
    private static void gerenciarItemOS() {   
        int opcao;
        OrdemServico ordemServico;
        
        do {
            opcao = InterfaceOS.exibirGerenciarItens();
            
            switch (opcao) {
                case 1 -> InterfaceOS.exibirAdicionarPeca();
                case 2 -> InterfaceOS.exibirAdicionarServico();
                case 3 -> InterfaceOS.exibirExcluirPeca();
                case 4 -> InterfaceOS.exibirExcluirServico();
                case 5 -> InterfaceOS.consultarTotalOS();
            }
        } while (!(opcao == 0 || opcao == 7)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    public static boolean adicionarItemOSPeca(OrdemServico ordemOS, Peca peca, int quantidade) {
        if(peca.subtrairEstoque(quantidade)){
            ordemOS.adicionarPeca('P', quantidade , peca);
            return true;
        }
        return false;
    }
    
    public static void adicionarItemOSServico(OrdemServico ordemOS, Servico servico, int quantidade) {
        ordemOS.adicionarServico('S', quantidade, servico);
    }
    
    public static ItemOS buscarItemOS(int id) {
        for (OrdemServico ordemOS : listaOS) {
            for(int i=0;i<ordemOS.getItensOS().size();i++)
            {
                if(ordemOS.getItensOS().get(i).getId() == id)
                {
                    return ordemOS.getItensOS().get(i);
                }
            }
        }
        return null;
    }
    
    public static void excluirItemOS(OrdemServico ordemOS, ItemOS itemOS) {
        ordemOS.removerItemOS(itemOS);
    }
    
    
    
    //METODOS PARA CONSULTAR O VALOR VENDIDO DURANTE UM PERIODO
    
 
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    
    public static String totalVendidoPeriodo(LocalDate dataInicio, LocalDate dataFinal)
    {
        String totalString ="";
        double total = 0;
        
        for (OrdemServico ordemOS : listaOS) {
            if(ordemOS.getSituação()=='F')
            {
                if(ordemOS.getDataOS().isBefore(dataFinal) && ordemOS.getDataOS().isAfter(dataInicio)
                    && ordemOS.getSituação()=='F')
                {
                    totalString = Oficina.verificarTotalOS(ordemOS);
                    if(isNumeric(totalString))
                    {
                        total += Double.parseDouble(totalString);
                    }
                }
            }
        }
        String totalFinalString = "" + total;
        return totalFinalString;    
    }

}
