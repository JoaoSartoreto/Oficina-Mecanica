package interfaces;

import classes.Cliente;
import classes.ItemOS;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import java.util.ArrayList;
import oficina.Oficina;

public class InterfaceOS {

    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de ordem de serviço.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        String mensagem= "";
        
        mensagem += "1 - Abrir nova ordem de serviço\n";
        mensagem += "2 - Gerenciar itens\n";
        mensagem += "3 - Cancelar\n";
        mensagem += "4 - Finalizar\n";
        mensagem += "5 - Excluir\n";
        mensagem += "6 - Listar todas as ordens\n";
        mensagem += "7 - Voltar";
        
        return Interface.exibirMenu("Gerenciar OS", mensagem, 7);
    }
    
    public static OrdemServico exibirAbrirOS()
    {
        String titulo = "Abir OS";
        String dataPrevTermino;
        String placaCarro;
        String cpfCliente;
        Cliente cliente;
        
        dataPrevTermino = Interface.exibirDialogoEntrada(titulo, "Data prevista para o término: ");
        if (dataPrevTermino == null) return null;
        
        placaCarro = Interface.exibirDialogoEntrada(titulo, "Placa do carro: ");
        if (placaCarro == null) return null;
        
        do {
            cpfCliente = Interface.exibirDialogoEntrada(titulo, "CPF do cliente: ");
            if (cpfCliente == null) return null;
            
            cliente = Oficina.buscarCliente(cpfCliente);
            if (cliente == null)
                Interface.exibirMensagemErro(titulo, "Cliente não encontrado");
            
        } while (cliente == null);
        
        
        return new OrdemServico(dataPrevTermino, placaCarro, cliente);
    }
    
    public static void exibirCancelarOS ()
    {
        String titulo = "Cancelar Ordem de Serviço";
        String numeroString;
        int numero;
        
        numeroString = Interface.exibirDialogoEntrada(titulo, "Número: ");
        
        if(numeroString != null) {
            numero = Integer.parseInt(numeroString);
            OrdemServico ordemOS = Oficina.buscarOS(numero);
            if(ordemOS!=null)
                Oficina.cancelarOS(ordemOS);
            else
                Interface.exibirMensagemErro(titulo, "Ordem de serviço não encontrada");
        }
    }
    
    public static void exibirFinalizarOS()
    {
        String titulo = "Finalizar Ordem de Serviço";
        String numeroString;
        int numero;
        
        numeroString = Interface.exibirDialogoEntrada(titulo, "Insira o indice da OS que deseja finalizar");
        if(numeroString!=null)
        {
            numero = Integer.parseInt(numeroString);
            OrdemServico ordemOS = Oficina.buscarOS(numero);
            if(ordemOS!=null)
                Oficina.finalizarOS(ordemOS);
            else
                Interface.exibirMensagemErro(titulo, "Ordem de serviço não encontrada");
        }        
    }
    
    public static void exibirExcluirOS()
    {
        String titulo = "Excluir Ordem de Serviço";
        String numero;
        
        numero = Interface.exibirDialogoEntrada(titulo, "Número: ");
        if (numero != null)
            switch(Oficina.excluirOS(Integer.parseInt(numero))){
                case 0 -> Interface.exibirMensagem(titulo, "OS excluída com sucesso");
                case 1 -> Interface.exibirMensagemErro(titulo, "OS não encontrada para exclusão");
                case 2 -> Interface.exibirMensagemErro(titulo, "Esta OS não está abertada");
            }
    }
    
    public static void exibirListaOS(ArrayList<OrdemServico> ordensOS)
    {
        String titulo = "Listar Ordens de Serviço";
        String saida= Oficina.listarOSs();
        
        Interface.exibirMensagem(titulo, saida);
    }

    // GERENCIAR ITENS
    
    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de itens de OS.
    // Devolve a opção selecionada (int).
    public static int exibirGerenciarItens() {
        String mensagem = "";
        
        mensagem += "1 - Adicionar peça\n";
        mensagem += "2 - Adicionar serviço\n";
        mensagem += "3 - Excluir peça\n";
        mensagem += "4 - Excluir serviço\n";
        mensagem += "5 - Consultar total\n";
        mensagem += "6 - Voltar";
        
        return Interface.exibirMenu("Gerenciar Itens de OS", mensagem, 6);
    }
    
    public static OrdemServico exibirSelecionarOS(String titulo)
    {    
        String numero;
        OrdemServico ordemServico;
        
        numero = Interface.exibirDialogoEntrada(titulo, "Número da OS: ");
        if(numero == null) return null;
        
        ordemServico = Oficina.buscarOS(Integer.parseInt(numero));
        if (ordemServico == null) Interface.exibirMensagem(titulo, "OS não encontrada");
        return ordemServico;
    }
    
    public static void exibirAdicionarPeca() {   
        String titulo = "Adicionar Peça à OS";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        if (ordemServico == null) return;
        if (ordemServico.getSituação() != 'A') {
            Interface.exibirMensagemErro(titulo, "A OS não está aberta");
            return;
        }
        
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código: ");
        if (codigo == null) return;
        
        Peca peca = Oficina.buscarPeca(Integer.parseInt(codigo));
        if (peca == null) {
            Interface.exibirMensagem(titulo, "Peça não encontrada");
            return;
        }
        
        String qtde = Interface.exibirDialogoEntrada(titulo, "Quantidade: ");
        if (qtde == null) return;
        
        if (Integer.parseInt(qtde) <= 0)
            Interface.exibirMensagemErro(titulo, "Quantidade inválida");
        
        if (Integer.parseInt(qtde) > peca.getQtdeEstoque())
            Interface.exibirMensagemErro(titulo, "Quantidade insuficiente no estoque");
        
        ordemServico.adicionarPeca(Integer.parseInt(qtde), peca);
        Interface.exibirMensagem(titulo, "Peça adiciona à OS com sucesso");
    }
           
    public static void exibirAdicionarServico() {   
        String titulo = "Adicionar Serviço à OS";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        if (ordemServico == null) return;
        if (ordemServico.getSituação() != 'A') {
            Interface.exibirMensagemErro(titulo, "A OS não está aberta");
            return;
        }
        
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código: ");
        if (codigo == null) return;
        
        Servico servico = Oficina.buscarServico(Integer.parseInt(codigo));
        if (servico == null) {
            Interface.exibirMensagem(titulo, "Serviço não encontrado");
            return;
        }
        
        String qtde = Interface.exibirDialogoEntrada(titulo, "Quantidade: ");
        if (qtde == null) return;
        
        if (Integer.parseInt(qtde) <= 0)
            Interface.exibirMensagemErro(titulo, "Quantidade inválida");
        
        ordemServico.adicionarServico(Integer.parseInt(qtde), servico);
        Interface.exibirMensagem(titulo, "Serviço adicionado à OS com sucesso");
    }
    
    public static void exibirExcluirPeca()
    {
        String titulo = "Excluir Peça da OS";
        String idItemOSString;
        int idItemOS;
        
        OrdemServico ordemOS = exibirSelecionarOS(titulo);
        if(ordemOS!=null)
        {
            idItemOSString = Interface.exibirDialogoEntrada(titulo, "Insira o id da peça que deseja remover");
            if(idItemOSString!=null)
            {
                idItemOS = Integer.parseInt(idItemOSString);
                ItemOS itemOS = Oficina.buscarItemOS(idItemOS);
                if(itemOS!=null)
                {
                    Oficina.excluirItemOS(ordemOS, itemOS);
                }
                else
                {
                    Interface.exibirMensagemErro(titulo, "Peça não encontrada");
                }
                
            }
        }
        else
        {
            Interface.exibirMensagemErro(titulo, "Ordem de Serviço não encontrada");
        }
       
    }
    
    public static void exibirExcluirServico()
    {
        String titulo = "Excluir serviço da OS";
        String idItemOSString;
        int idItemOS;
        
        OrdemServico ordemOS = exibirSelecionarOS(titulo);
        if(ordemOS!=null)
        {
            idItemOSString = Interface.exibirDialogoEntrada(titulo, "Insira o id do serviço que deseja remover");
            if(idItemOSString!=null)
            {
                idItemOS = Integer.parseInt(idItemOSString);
                ItemOS itemOS = Oficina.buscarItemOS(idItemOS);
                if(itemOS!=null)
                {
                    Oficina.excluirItemOS(ordemOS, itemOS);
                }
                else
                {
                    Interface.exibirMensagemErro(titulo, "Serviço não encontrado");
                }
                
            }
        }
        else
        {
            Interface.exibirMensagemErro(titulo, "Ordem de Serviço não encontrada");
        }
    }
    
    public static String consultarTotalOS()
    {
        // Aqui terá que passar uma String ou OS e mostrar o total dela;
        
        
        OrdemServico ordemOS = exibirAbrirOS();
        if(ordemOS !=null)
        {
            String totalString = "";
            double total;
            total = ordemOS.valorOS();
            totalString += total;
        
            Interface.exibirMensagem("Valor total da OS: " + ordemOS.getNumeroOS(), totalString);
        }
        
        
        return "Não possui valor";
        
        //Desse jeito?
        
    }
}
