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
    
    
    //Metodo para o usuario escolher a Ordem de Serviço que deseja alterar
    public static OrdemServico exibirSelecionarOS(String titulo)
    {    
        String indexString;
        int index;
        indexString = Interface.exibirDialogoEntrada(titulo, "Número da OS: ");
        if(indexString!=null)
        {
            index = Integer.parseInt(indexString);
            OrdemServico ordemOS = Oficina.buscarOS(index);
            return ordemOS;
        }
        return null;
    }
    // TODO método para selecionar peça
    
    
    //Chama o selecionador de ordem de serviços, e verifica se os valroes inseridos pelo usuario
    //são validos. Se forem ele chama o metodo da oficina responsavel por adicionar a peça
    public static void exibirAdicionarPeca()
    {
        String titulo = "Adicionar Peça a OS";
        String codPecaString;
        int codPeca;
        
        OrdemServico ordemOS = exibirSelecionarOS(titulo);
        if(ordemOS!=null)
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
                        if(Oficina.adicionarItemOSPeca(ordemOS, peca, qtde))
                        {
                            Interface.exibirMensagem(titulo, "Peça cadastrada com sucesso na OS");
                        }
                        else
                        {
                            Interface.exibirMensagemErro(titulo, "Falha ao cadastrar peça na OS");
                        }
                    }
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
    
    // TODO método para selecionar serviço
    
    //Chama o selecionador de ordem de serviços, e verifica se os valroes inseridos pelo usuario
    //são validos. Se forem ele chama o metodo da oficina responsavel por adicionar o serviço
    public static void exibirAdicionarServico() {
        String titulo = "Adicionar Serviço a OS";
        String codServicoString;
        int codServico;
        
        OrdemServico ordemOS = exibirSelecionarOS(titulo);
        if(ordemOS!=null)
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
                        Oficina.adicionarItemOSServico(ordemOS, servico, qtde);
                        Interface.exibirMensagem(titulo, "Serviço cadastrada com sucesso na OS");
                    }
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
    
    //Chama o selecionador de ordem de serviços, e verifica se os valroes inseridos pelo usuario
    //são validos. Se forem ele chama o metodo da oficina responsavel por excluir a peça
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
    
    //Chama o selecionador de ordem de serviços, e verifica se os valroes inseridos pelo usuario
    //são validos. Se forem ele chama o metodo da oficina responsavel por excluir o serviço
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
    
    
    //Chama o selecionador de ordem de serviços, e verifica se os valroes inseridos pelo usuario
    //são validos. Se forem ele chama o metodo da oficina responsavel consultar o valor de uma ordem de serviço
    public static void consultarTotalOS()
    {
        // Aqui terá que passar uma String ou OS e mostrar o total dela;
        
        String titulo = "Excluir serviço da OS";
        String idItemOSString;
        int idItemOS;
        
        OrdemServico ordemOS = exibirSelecionarOS(titulo);
        if(ordemOS!=null)
        {
            String totalString;
            totalString = Oficina.verificarTotalOS(ordemOS);
            totalString += "\n"+ordemOS.listaItensOS();
            Interface.exibirMensagem(titulo, "O total dessa Ordem de Serviço é: "+totalString);
        }
        else
        {
            Interface.exibirMensagemErro(titulo, "Ordem de Serviço não encontrada");
        }
    }
}
