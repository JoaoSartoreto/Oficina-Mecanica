package oficina;
import java.util.ArrayList;

import classes.Cliente;
import classes.ItemOS;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import excecoes.cliente.ClienteReferenciadoException;
import excecoes.itemos.AdicionarItemOSNaoAbertaException;
import excecoes.cliente.ClienteNaoEncontradoException;
import excecoes.os.OSNaoAbertaException;
import excecoes.produto.peca.EstoqueInsuficienteException;
import excecoes.itemos.ItemNaoEncontradoException;
import excecoes.os.OSNaoEncontradaException;
import excecoes.produto.peca.PecaNaoEncontradaException;
import excecoes.produto.peca.PecaReferenciadaException;
import excecoes.QuantidadeInvalidaException;
import excecoes.itemos.RemoverItemOSNaoAbertaException;
import excecoes.produto.servico.ServicoNaoEncontradoException;
import excecoes.produto.servico.ServicoReferenciadoException;
import gui.MenuPrincipal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import operacoes.IO;

public class Oficina {

    private static ArrayList<Cliente> listaClientes = IO.leituraClientes();
    private static ArrayList<OrdemServico> listaOS = IO.leituraOS();
    private static ArrayList<Peca> listaPecas = IO.leituraPecas();
    private static ArrayList<Servico> listaServicos = IO.leituraServicos();

    /* MAIN */
    public static void main(String[] args) {        
        criarMenuPrincipal();          
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
    public static Cliente buscarCliente(String cpf) throws ClienteNaoEncontradoException{
        for (Cliente cliente : listaClientes) 
            if (cliente.getCpf().equals(cpf)) return cliente;
        
        throw new ClienteNaoEncontradoException();
    }
    
    /*
    Busca um cliente pelo CPF e se não houver nenhum erro o remove da lista.
    Se houver algum erro é lançada uma exceção;
    */
    public static void excluirCliente(String cpf) throws ClienteReferenciadoException, ClienteNaoEncontradoException{
        Cliente cliente = buscarCliente(cpf);
         
        if (cliente == null) throw new ClienteNaoEncontradoException();
        for (OrdemServico ordemServico : listaOS)
            if (ordemServico.getCliente() == cliente) throw new ClienteReferenciadoException();
        
        listaClientes.remove(cliente);
        

    }

    /* -- MÉTODOS RELACIONADOS ÀS PEÇAS -- */
    
    public static ArrayList<Peca> getListaPecas() {
        return listaPecas;
    }
    
    /* 
    Percorre a lista de peças verificando o código das peças.
    Se encontrar uma peça com código correspondente ela é devolvida, senão é devolvido null.
    */
    public static Peca buscarPeca(int codPeca) throws PecaNaoEncontradaException{
        for (Peca peca : listaPecas)
            if(peca.getCodigo() == codPeca) return peca;

        throw new PecaNaoEncontradaException();
    }
    
    /*
    Busca uma peça pelo código e se não houver nenhum erro a remove da lista.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static void excluirPeca(int codPeca) throws PecaReferenciadaException, PecaNaoEncontradaException{
        Peca peca = buscarPeca(codPeca);
        
        if (peca == null) throw new PecaNaoEncontradaException();
        
        for (OrdemServico ordemServico : listaOS)
            for (ItemOS itemOS : ordemServico.getItensOS())
                if (itemOS.getProduto().getCodigo() == peca.getCodigo()) throw new PecaReferenciadaException();
        
        listaPecas.remove(peca);
    }
    
    /* -- MÉTODOS RELACIONADOS AOS SERVIÇOS -- */
    
    public static ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }
    
    /*
    Percorre a lista de serviços verificando os códigos.
    Se encontrar um serviço com código correspondente ele é devolvido, senão é devolvido null.
    */
    public static Servico buscarServico(int codServico) throws ServicoNaoEncontradoException{
        for (Servico servico : listaServicos)
            if(servico.getCodigo() == codServico)
                return servico;
            
        throw new ServicoNaoEncontradoException();
    }
    
    /*
    Busca um serviço pelo código e se não houver nenhum erro o remove da lista.
    Se houver algum erro é lançada uma exceção;
    */
    public static void excluirServico(int codServico) throws ServicoReferenciadoException, ServicoNaoEncontradoException{
        Servico servico = buscarServico(codServico);
        
        if (servico == null) throw new ServicoNaoEncontradoException();
        
        for (OrdemServico ordemServico : listaOS)
            for (ItemOS itemOS : ordemServico.getItensOS())
                if (itemOS.getProduto().getCodigo() == servico.getCodigo()) throw new ServicoReferenciadoException() ;
        
        listaServicos.remove(servico);
    }
    
    /* -- MÉTODOS RELACIONADOS À OS -- */
    
    public static ArrayList<OrdemServico> getListaOS() {
        return listaOS;
    }

    /*
    Percorre a lista de OS verificando os números.
    Se encontrar uma OS com número correspondente ela é devolvida, senão é devolvido null.
    */
    public static OrdemServico buscarOS(int numero) throws OSNaoEncontradaException{
        for (OrdemServico ordemOS : listaOS)
            if(ordemOS.getNumeroOS() == numero)
                return ordemOS;
            
        throw new OSNaoEncontradaException();
    }
    
    /*
    Busca uma OS pelo número e se não houver nenhum erro a cancela.
    Se houver algum erro é lançada uma exceção;
    */
    public static void cancelarOS(int numero) throws OSNaoAbertaException, OSNaoEncontradaException {
        OrdemServico ordemServico = buscarOS(numero);
        if (ordemServico == null) throw new OSNaoEncontradaException();
        ordemServico.cancelarOS();
    }
    
    /*
    Busca uma OS pelo número e se não houver nenhum erro a finaliza.
    Se houver algum erro é lançada uma exceção;
    */
    public static void finalizarOS(int numero) throws OSNaoAbertaException, OSNaoEncontradaException {
        OrdemServico ordemServico = buscarOS(numero);
        if (ordemServico == null) throw new OSNaoEncontradaException();
        ordemServico.finalizarOS();       
    }
    
    /*
    Busca uma OS pelo número e se não houver nenhum erro a cancela (para devolver as peças) e a remove da lista.
    Devolve um int representando o sucesso da operação ou especificando o erro. 
    */
    public static void excluirOS(int numero) throws OSNaoAbertaException, OSNaoEncontradaException {
        OrdemServico ordemServico = buscarOS(numero);
     
        if (ordemServico == null) throw new OSNaoEncontradaException();
        
        ordemServico.cancelarOS();       
        listaOS.remove(ordemServico);
    }
    
    
    /* 
    Fizemos os métodos de adição e exclusão de ItemOS pois o enunciado pede para que Oficina implemente esta funcionalidade, mas 
    deixamos as verificações do lado da OrdemServico para que ela não dependa da Oficina, evitando assim manipulações indevidas.
    */

    public static void adicionarItemOSPeca(OrdemServico ordemServico, Peca peca, int quantidade) throws AdicionarItemOSNaoAbertaException, EstoqueInsuficienteException, QuantidadeInvalidaException {
        ordemServico.adicionarPeca(quantidade, peca);
    }
    
    public static void adicionarItemOSServico(OrdemServico ordemServico, Servico servico, int quantidade) throws AdicionarItemOSNaoAbertaException, QuantidadeInvalidaException {
        ordemServico.adicionarServico(quantidade, servico);
    }
    
    public static void excluirItemOSPeca(OrdemServico ordemOS, int codigo) throws RemoverItemOSNaoAbertaException, ItemNaoEncontradoException{
        ordemOS.removerItemOSPeca(codigo);
    }
    
    public static void excluirItemOSServico(OrdemServico ordemOS, int codigo) throws RemoverItemOSNaoAbertaException, ItemNaoEncontradoException{
        ordemOS.removerItemOSServico(codigo);
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
    
    public static void criarMenuPrincipal()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal(listaClientes, listaOS, listaPecas, listaServicos);
            }
        });
    }
}
