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
        
        if(numeroString!=null)
        {
            numero = Integer.parseInt(numeroString);
            OrdemServico ordemOS = Oficina.buscarOS(numero);
            if(ordemOS!=null)
            {
                Oficina.cancelarOS(ordemOS);
            }
            else
            {
                Interface.exibirMensagemErro(titulo, "Ordem de serviço não encontrada");
            }
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
            {
                Oficina.finalizarOS(ordemOS);
            }
            else
            {
                Interface.exibirMensagemErro(titulo, "Ordem de serviço não encontrada");
            }
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
    
    // TODO método para selecionar OS
    
    public static String exibirSelecionarOS(String titulo)
    {    
        return Interface.exibirDialogoEntrada(titulo, "Número da OS: ");
    }
    // TODO método para selecionar peça
    
    public static boolean exibirAdicionarPeca()
    {
        String titulo = "Adicionar Peça a OS";
        int index;
        String codPecaString;
        int codPeca;
        
        index = exibirSelecionarOS();
        if(index>=0)
        {
            codPecaString = Interface.exibirDialogoEntrada(titulo, "Insira o codigo da peça que deseja inserir");
            if(codPecaString!=null)
            {
                codPeca = Integer.parseInt(codPecaString);
                Peca peca = Oficina.buscarPeca(codPeca);
                if(peca != null)
                {
                    String qtdeString;
                    int qtde;
                    qtdeString = Interface.exibirDialogoEntrada(titulo, "Informe a quantidade de peças");
                    if(qtdeString!=null)
                    {
                        qtde = Integer.parseInt(qtdeString);
                        if(Oficina.adicionarItemOSPeca(index, peca, qtde))
                        {
                            Interface.exibirMensagem(titulo, "Peça cadastrada com sucesso na OS");
                            return true;
                        }
                        else
                        {
                            Interface.exibirMensagemErro(titulo, "Falha ao cadastrar peça na OS");
                            return false;
                        }
                    }
                }
                else
                {
                    Interface.exibirMensagemErro(titulo, "Peça não encontrada");
                }
            }
        }
       Interface.exibirMensagemErro(titulo, "Ordem de Serviço não encontrada");
       return false;
    }
    
    // TODO método para selecionar serviço
    
    public static boolean exibirAdicionarServico() {
        String titulo = "Adicionar Serviço a OS";
        int index;
        String codServicoString;
        int codServico;
        
        index = exibirSelecionarOS();
        if(index>=0)
        {
            codServicoString = Interface.exibirDialogoEntrada(titulo, "Insira o codigo do serviço que deseja inserir");
            if(codServicoString!=null)
            {
                codServico = Integer.parseInt(codServicoString);
                Servico servico = Oficina.buscarServico(codServico);
                if(servico != null)
                {
                    String qtdeString;
                    int qtde;
                    qtdeString = Interface.exibirDialogoEntrada(titulo, "Informe a quantidade de serviços");
                    if(qtdeString!=null)
                    {
                        qtde = Integer.parseInt(qtdeString);
                        Oficina.adicionarItemOSServico(index, servico, qtde);
                        Interface.exibirMensagem(titulo, "Peça cadastrada com sucesso na OS");
                        return true;
                    }
                }
                else
                {
                    Interface.exibirMensagemErro(titulo, "Serviço não encontrado");
                }
            }
        }
        Interface.exibirMensagemErro(titulo, "Ordem de Serviço não encontrada");
        return false;
    }
    
    public static String consultarTotalOS(OrdemServico ordemOS)
    {
        // Aqui terá que passar uma String ou OS e mostrar o total dela;
        String totalString = "";
        double total;
        
        total = ordemOS.valorOS();
        totalString += total;
        
        Interface.exibirMensagem("Valor total da OS: " + ordemOS.getNumeroOS(), totalString);
        return totalString;
        
        //Desse jeito?
        
    }
}
