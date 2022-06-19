package oficina;
import java.util.ArrayList;

import classes.Cliente;
import classes.ItemOS;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import excecoes.ClienteException;
import excecoes.ItemOSException;
import excecoes.OrdemServicoException;
import excecoes.PecaEstoqueException;
import excecoes.PecaException;
import excecoes.ServicoException;
import interfaces.Interface;
import interfaces.InterfaceClientes;
import interfaces.InterfaceOS;
import interfaces.InterfacePecas;
import interfaces.InterfacePrincipal;
import interfaces.InterfaceServicos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Oficina {

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ArrayList<OrdemServico> listaOS = new ArrayList<>();
    private static ArrayList<Peca> listaPecas = new ArrayList<>();
    private static ArrayList<Servico> listaServicos = new ArrayList<>();

    /* MAIN */
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

    /* -- OUTROS MÉTODOS -- */
    
    /* -- MÉTODOS RELACIONADOS AOS CLIENTES -- */
    
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    /* 
    Percorre a lista de clientes verificando o CPF dos clientes.
    Se encontrar um cliente com CPF correspondente ele é devolvido, senão é devolvido null.
    */
    public static Cliente buscarCliente(String cpf) {
        for (Cliente cliente : listaClientes) 
            if (cliente.getCpf().equals(cpf)) return cliente;

        return null;
    }
    
    /*
    Busca um cliente pelo CPF e se não houver nenhum erro o remove da lista.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static int excluirCliente(String cpf) throws ClienteException{
        Cliente cliente = buscarCliente(cpf);
        
        if (cliente == null) return 1;
        
        for (OrdemServico ordemServico : listaOS)
            if (ordemServico.getCliente() == cliente) throw new ClienteException();
        
        listaClientes.remove(cliente);
        
        return 0;
    }

    /*
    Chama os menus e diálogos relacionadas ao gerenciamento de clientes de acordo com as opções selecionadas.
    Também recebe os resultados desses métodos para manipular os elementos da lista de clientes.
    */
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
    
    /* -- MÉTODOS RELACIONADOS ÀS PEÇAS -- */
    
    public static ArrayList<Peca> getListaPecas() {
        return listaPecas;
    }
    
    /* 
    Percorre a lista de peças verificando o código das peças.
    Se encontrar uma peça com código correspondente ela é devolvida, senão é devolvido null.
    */
    public static Peca buscarPeca(int codPeca) {
        for (Peca peca : listaPecas)
            if(peca.getCodigo() == codPeca) return peca;

        return null;
    }
    
    /*
    Busca uma peça pelo código e se não houver nenhum erro a remove da lista.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static int excluirPeca(int codPeca) throws PecaException{
        Peca peca = buscarPeca(codPeca);
        
        if (peca == null) return 1;
        
        for (OrdemServico ordemServico : listaOS)
            for (ItemOS itemOS : ordemServico.getItensOS())
                if (itemOS.getProduto().getCodigo() == peca.getCodigo()) throw new PecaException();
        
        listaPecas.remove(peca);
        
        return 0;
    }
    
    /*
    Chama os menus e diálogos relacionadas ao gerenciamento de peças de acordo com as opções selecionadas.
    Também recebe os resultados desses métodos para manipular os elementos da lista de peças.
    */
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
    
    /* -- MÉTODOS RELACIONADOS AOS SERVIÇOS -- */
    
    public static ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }
    
    /*
    Percorre a lista de serviços verificando os códigos.
    Se encontrar um serviço com código correspondente ele é devolvido, senão é devolvido null.
    */
    public static Servico buscarServico(int codServico) {
        for (Servico servico : listaServicos)
            if(servico.getCodigo() == codServico)
                return servico;
            
        return null;
    }
    
    /*
    Busca um serviço pelo código e se não houver nenhum erro o remove da lista.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static int excluirServico(int codServico) throws ServicoException{
        Servico servico = buscarServico(codServico);
        
        if (servico == null) return 1;
        
        for (OrdemServico ordemServico : listaOS)
            for (ItemOS itemOS : ordemServico.getItensOS())
                if (itemOS.getProduto().getCodigo() == servico.getCodigo()) throw new ServicoException() ;
        
        listaServicos.remove(servico);
        
        return 0;
    }
    
    /*
    Chama os menus e diálogos relacionadas ao gerenciamento de serviços de acordo com as opções selecionadas.
    Também recebe os resultados desses métodos para manipular os elementos da lista de serviços.
    */
    private static void gerenciarServicos() {
        int opcao;

        do {
            opcao = InterfaceServicos.exibir();
            switch (opcao) {
                case 1 -> {
                    Servico servico = InterfaceServicos.exibirCadastroServico();
                    if (servico != null) listaServicos.add(servico);
                }
                case 2 -> InterfaceServicos.exibirConsultarServico();
                case 3 -> InterfaceServicos.exibirExcluirServico();
                case 4 -> InterfaceServicos.exibirEditarServico();
                case 5 -> InterfaceServicos.exibirListarServicos();
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    /* -- MÉTODOS RELACIONADOS À OS -- */
    
    public static ArrayList<OrdemServico> getListaOS() {
        return listaOS;
    }

    /*
    Percorre a lista de OS verificando os números.
    Se encontrar uma OS com número correspondente ela é devolvida, senão é devolvido null.
    */
    public static OrdemServico buscarOS(int numero) {
        for (OrdemServico ordemOS : listaOS)
            if(ordemOS.getNumeroOS() == numero)
                return ordemOS;
            
        return null;
    }
    
    /*
    Busca uma OS pelo número e se não houver nenhum erro a cancela.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static int cancelarOS(int numero) throws OrdemServicoException {
        OrdemServico ordemServico = buscarOS(numero);
        
        if (ordemServico == null) return 1;

        ordemServico.cancelarOS();
        return 0;
    }
    
    /*
    Busca uma OS pelo número e se não houver nenhum erro a finaliza.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static int finalizarOS(int numero) throws OrdemServicoException {
        OrdemServico ordemServico = buscarOS(numero);
        
        if (ordemServico == null) return 1;
        
        ordemServico.finalizarOS();       
        return 0;
    }
    
    /*
    Busca uma OS pelo número e se não houver nenhum erro a cancela (para devolver as peças) e a remove da lista.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static int excluirOS(int numero) throws OrdemServicoException {
        OrdemServico ordemServico = buscarOS(numero);
        
        if (ordemServico == null) return 1;
        
        ordemServico.cancelarOS();       
        listaOS.remove(ordemServico);
        return 0;
    }
    
    /*
    Chama os menus e diálogos relacionadas ao gerenciamento de OS de acordo com as opções selecionadas.
    Também recebe os resultados desses métodos para manipular os elementos da lista de OS.
    */
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
                case 6 -> InterfaceOS.exibirListaOS();
            }
        } while (!(opcao == 0 || opcao == 7)); // Enquanto não fechar a janela ou selecionar a opção 7
    }
    
    /* -- MÉTODOS RELACIONADOS AOS ITENS DE OS -- */
    
    /* Chama os menus relacionadas ao gerenciamento de itens de OS de acordo com as opções selecionadas. */
    private static void gerenciarItemOS() {   
        int opcao;
        
        do {
            opcao = InterfaceOS.exibirGerenciarItens();
            
            switch (opcao) {
                case 1 -> InterfaceOS.exibirAdicionarPeca();
                case 2 -> InterfaceOS.exibirAdicionarServico();
                case 3 -> InterfaceOS.exibirExcluirPeca();
                case 4 -> InterfaceOS.exibirExcluirServico();
                case 5 -> InterfaceOS.exibirConsultarTotal();
            }
        } while (!(opcao == 0 || opcao == 6)); // Enquanto não fechar a janela ou selecionar a opção 6
    }
    
    /* 
    Fizemos os métodos de adição e exclusão de ItemOS pois o enunciado pede para que Oficina implemente esta funcionalidade, mas 
    deixamos as verificações do lado da OrdemServico para que ela não dependa da Oficina, evitando assim manipulações indevidas.
    */

    public static boolean adicionarItemOSPeca(OrdemServico ordemServico, Peca peca, int quantidade) throws ItemOSException, PecaEstoqueException {
        return ordemServico.adicionarPeca(quantidade, peca);
    }
    
    public static boolean adicionarItemOSServico(OrdemServico ordemServico, Servico servico, int quantidade) throws ItemOSException {
        return ordemServico.adicionarServico(quantidade, servico);
    }
    
    public static boolean excluirItemOSPeca(OrdemServico ordemOS, int codigo) throws ItemOSException{
        return ordemOS.removerItemOSPeca(codigo);
    }
    
    public static boolean excluirItemOSServico(OrdemServico ordemOS, int codigo) throws ItemOSException{
        return ordemOS.removerItemOSServico(codigo);
    }
    
    /* -- CONSULTA DO VALOR VENDIDO DURANTE UM PERIODO -- */
    
    /*
    Percorre a lista de OS adicionando o valor total das OS finalizadas cujas datas de término são depois ou igual à data de início  do período e antes ou igual à data final do período. 
    */
    public static double getTotalVendidoPeriodo(String textDataInicio, String textDataFinal)
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate dataInicio = LocalDate.parse(textDataInicio, formato);
        LocalDate dataFinal = LocalDate.parse(textDataFinal, formato);
        
        double total = 0;
        
        for (OrdemServico ordemServico : listaOS)
            if(ordemServico.getSituação() == 'F'){
                LocalDate dataTermino = ordemServico.getDataTermino();
                boolean depoisInicio = dataTermino.isAfter(dataInicio) || dataTermino.equals(dataInicio);
                boolean antesFinal = dataTermino.isBefore(dataFinal) || dataTermino.equals(dataFinal);
                if(depoisInicio && antesFinal)
                    total += ordemServico.getValorOS();
            } 
        
        return total;
    }

}
