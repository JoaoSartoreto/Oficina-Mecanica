package interfaces;

import classes.Cliente;
import classes.Exceptions.ExcluiClienteEx.*;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import java.util.ArrayList;
import oficina.Oficina;

public class InterfaceOS {

    /*
    Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de ordem de serviço.
    Devolve a opção selecionada (int).
    */
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
    
    /*
    Chama diálogos de entrada para receber os atributos de uma OS e devolve um objeto OrdemServico.
    Se em algum momento o diálogo de entrada for cancelado (devolver null) o método devolve null.
    O método também chama um método da Oficina para verificar se existe o cliente informado para a OS,
    se o cliente não for encontrado é exibida uma mensagem de erro.
    */
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
    
    /* 
    Utiliza um diálogo de entrada para receber o número da OS a busca pelo seu número para excluí-la.
    Se o número da OS não for null (operação não ter sido cancelada), é buscada a OS pelo número e se ela existir
    (não for null) ela é cancelada.
    O êxito da operação ou o erro que ocorreu é informado por uma mensagem.
    */
    public static void exibirCancelarOS ()
    {
        String titulo = "Cancelar Ordem de Serviço";
        String numero;
        
        numero = Interface.exibirDialogoEntrada(titulo, "Número da OS: ");
        if (numero != null)
            try {
                switch(Oficina.cancelarOS(Integer.parseInt(numero))){
                    case 0 -> Interface.exibirMensagem(titulo, "OS cancelada com sucesso");
                    case 1 -> Interface.exibirMensagemErro(titulo, "OS não encontrada para exclusão");
                    case 2 -> throw new OSFechadaEx();//Exceção
                }
            } catch (OSFechadaEx e) {
                Interface.exibirMensagemErro(titulo, e.getMessage());
            }
    }
    
    /* 
    Utiliza um diálogo de entrada para receber o número da OS a busca pelo seu número para excluí-la.
    Se o número da OS não for null (operação não ter sido cancelada), é buscada a OS pelo número e se não ocorrer
    nenhum erro ela é finalizada.
    O êxito da operação ou o erro que ocorreu é informado por uma mensagem.
    */
    public static void exibirFinalizarOS()
    {
        String titulo = "Finalizar Ordem de Serviço";
        String numero;
        
        numero = Interface.exibirDialogoEntrada(titulo, "Número da OS: ");
        if (numero != null)
            try {
                switch(Oficina.finalizarOS(Integer.parseInt(numero))){
                    case 0 -> Interface.exibirMensagem(titulo, "OS finalizada com sucesso");
                    case 1 -> Interface.exibirMensagemErro(titulo, "OS não encontrada para finalizar");
                    case 2 -> throw new OSFechadaEx();  //Exceção
                }
            } catch (OSFechadaEx e) {
                Interface.exibirMensagemErro(titulo, e.getMessage());
            }        
    }
    
    /* 
    Utiliza um diálogo de entrada para receber o número da OS a busca pelo seu número para excluí-la.
    Se o número da OS não for null (operação não ter sido cancelada), é buscada a OS pelo número e se não ocorrer
    nenhum erro ela é excluída chamando o método Oficina.excluirOS(int numero).
    O êxito da operação ou o erro que ocorreu é informado por uma mensagem.
    */
    public static void exibirExcluirOS()
    {
        String titulo = "Excluir Ordem de Serviço";
        String numero;
        
        numero = Interface.exibirDialogoEntrada(titulo, "Número da OS: ");
        if (numero != null)
            try {
                switch(Oficina.excluirOS(Integer.parseInt(numero))){
                    case 0 -> Interface.exibirMensagem(titulo, "OS excluída com sucesso");
                    case 1 -> Interface.exibirMensagemErro(titulo, "OS não encontrada para exclusão");
                    case 2 -> throw new OSFechadaEx();
                }
            } catch (OSFechadaEx e) {
                Interface.exibirMensagemErro(titulo,e.getMessage());
            }
    }
    
    /* Percorre a lista de OS para formar uma String com a lista e a exibe em uma mensagem. */
    public static void exibirListaOS()
    {
        ArrayList<OrdemServico> listaOS = Oficina.getListaOS();
        String mensagem = "";
            
        for(OrdemServico ordemServico : listaOS)
            mensagem += ordemServico.toString() + "\n";
        
        Interface.exibirMensagem("Listar Ordens de Serviço", mensagem);
    }

    /* -- GERENCIAMENTO DE ITENS DA OS -- */
    
    /*
    Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de itens de OS.
    Devolve a opção selecionada (int).
    */
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
    
    /*
    Exibe um diálogo para receber o número da OS e buscar por ela.
    Caso a operação não seja cancelada e a OS exista ela é devolvida.
    Se a OS não for encontrada é exibida uma mensagem de erro.
    */
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
    
    /*
    Exibe a seleção de OS e um diálogo para selecionar a peça pelo seu código.
    Se em algum momento ocorrer algum erro, como tentar adicionar a peça em uma OS que não esteja aberta,
    é exibida uma mensagem informando o erro.
    Se em nenhum momento alguma inserção for cancelada e não ocorrer nenhum erro a peça é adicionada à OS
    e o êxito é informado por uma mensagem.
    */
    public static void exibirAdicionarPeca() {   
        String titulo = "Adicionar Peça à OS";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        try {
            if (ordemServico == null) return;
            if (ordemServico.getSituação() != 'A') {    //Exceção
                throw new OSFechadaEx();
            }
            return;
        } catch (OSFechadaEx e) {
            Interface.exibirDialogoEntrada(titulo, e.getMessage());
        }
        
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código da peça: ");
        if (codigo == null) return;
        
        Peca peca = Oficina.buscarPeca(Integer.parseInt(codigo));
        if (peca == null) {
            Interface.exibirMensagem(titulo, "Peça não encontrada");
            return;
        }
        
        String qtde = Interface.exibirDialogoEntrada(titulo, "Quantidade: ");
        if (qtde == null) return;
        
        if (Integer.parseInt(qtde) <= 0) {
            Interface.exibirMensagemErro(titulo, "Quantidade inválida");
            return;
        }
            
        try {
            if (Integer.parseInt(qtde) > peca.getQtdeEstoque()) {   //Exceção
                throw new SemEstoqueEx();
            }
            return;
        } catch (SemEstoqueEx e) {
            Interface.exibirMensagemErro(titulo, e.getMessage());
        }
            
        
        ordemServico.adicionarPeca(Integer.parseInt(qtde), peca);
        Interface.exibirMensagem(titulo, "Peça adiciona à OS com sucesso");
    }
    
    /*
    Exibe a seleção de OS e um diálogo para selecionar o serviço pelo seu código.
    Se em algum momento ocorrer algum erro, como tentar adicionar um serviço que não existe,
    é exibida uma mensagem informando o erro.
    Se em nenhum momento alguma inserção for cancelada e não ocorrer nenhum erro o serviço é adicionado à OS
    e o êxito é informado por uma mensagem.
    */
    public static void exibirAdicionarServico() {   
        String titulo = "Adicionar Serviço à OS";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        try {
            if (ordemServico == null) return;
            if (ordemServico.getSituação() != 'A') {
                throw new OSFechadaEx();
            }
        } catch (OSFechadaEx e) {
            Interface.exibirMensagemErro(titulo,e.getMessage());
            return;
        }
        
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código do serviço: ");
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
    
    /*
    Exibe a seleção de OS e um diálogo para selecionar a peça pelo seu código.
    Se em algum momento ocorrer algum erro, como tentar excluir uma peça que não esteja na OS,
    é exibida uma mensagem informando o erro.
    Se em nenhum momento alguma inserção for cancelada e não ocorrer nenhum erro a peça é excluída da OS
    e o êxito é informado por uma mensagem.
    */
    public static void exibirExcluirPeca() {   
        String titulo = "Excluir Peça da OS";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        try {
            if (ordemServico == null) return;
            if (ordemServico.getSituação() != 'A') {   //Exeção
                throw new OSFechadaEx();
            }
            return;
        } catch (OSFechadaEx e){
            Interface.exibirMensagemErro(titulo, e.getMessage());
        }
        
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código da peça: ");
        if (codigo == null) return;
        
        if (Oficina.excluirItemOSPeca(ordemServico, Integer.parseInt(codigo)))
            Interface.exibirMensagem(titulo, "Item excluído com sucesso");
        else 
            Interface.exibirMensagemErro(titulo, "Item não encontrado para exclusão");
    }
    
    /*
    Exibe a seleção de OS e um diálogo para selecionar o serviço pelo seu código.
    Se em algum momento ocorrer algum erro, como tentar excluir um serviço que não exista,
    é exibida uma mensagem informando o erro.
    Se em nenhum momento alguma inserção for cancelada e não ocorrer nenhum erro o serviço é excluído da OS
    e o êxito é informado por uma mensagem.
    */
    public static void exibirExcluirServico() {   
        String titulo = "Excluir Serviço da OS";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        try {
            if (ordemServico == null) return;
            if (ordemServico.getSituação() != 'A') {    //Exceção
                throw new OSFechadaEx();
            }
            return;
        } catch (OSFechadaEx e) {
            Interface.exibirMensagemErro(titulo, e.getMessage());
        }
        
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código do serviço: ");
        if (codigo == null) return;
        
        if (Oficina.excluirItemOSServico(ordemServico, Integer.parseInt(codigo)))
            Interface.exibirMensagem(titulo, "Serviço excluído com sucesso");
        else 
            Interface.exibirMensagemErro(titulo, "Serviço não encontrado para exclusão");
    }
    
    /*
    Exibe a seleção de OS e se ela existir chama seu método consultarTotal() para exibir
    o seu total em uma mensagem.
    */
    public static void exibirConsultarTotal() {
        
        String titulo = "Consultar Total";
        
        OrdemServico ordemServico = exibirSelecionarOS(titulo);
        if (ordemServico == null) return;
        
        Interface.exibirMensagem(titulo, ordemServico.consultarTotal());
    }
}
