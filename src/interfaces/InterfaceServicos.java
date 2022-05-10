package interfaces;

import classes.Servico;
import java.util.ArrayList;
import oficina.Oficina;

public class InterfaceServicos {
    
    // Chama o método exibir() de MenuItem passando "Peças" como o tipo de item para exibir o menu de gerenciamento de peças.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        return InterfaceItem.exibir("Serviços");
    }
    
    // Chama diálogos de entrada para receber os atributos de um cliente e devolve um objeto Cliente.
    // Se em algum momento o diálogo de entrada for cancelado (devolver null) o método devolve null.
    // O método também chama um método da Oficina para verificar se o CPF inserido já foi cadastrado.
    public static Servico exibirCadastroServico() {
        String titulo = "Cadastrar Serviço";
        String descricao;
        String stringPreco;
        double preco;
        String tempoExecucao;
        int diasExecucao;
        int horasExecucao;
        int minutosExecucao;
        int segundosExecucao;

        descricao = Interface.exibirDialogoEntrada(titulo, "Descrição: ");
        if (descricao == null) return null;

        stringPreco = Interface.exibirDialogoEntrada(titulo, "Preço: ");
        if (stringPreco == null) return null;
        preco = Double.parseDouble(stringPreco);
        
        tempoExecucao = Interface.exibirDialogoEntrada(titulo, "Tempo de execução (dd:hh:mm:ss): ");
        if (tempoExecucao == null) return null;
        
        try{
            diasExecucao = Integer.parseInt(tempoExecucao.split(":")[0]);
            horasExecucao = Integer.parseInt(tempoExecucao.split(":")[1]);
            minutosExecucao = Integer.parseInt(tempoExecucao.split(":")[2]);
            segundosExecucao = Integer.parseInt(tempoExecucao.split(":")[3]);
        } catch (Exception e) {
            // Aqui deve ser mantido como Exception, independente do tipo da exceção o comportamento será o mesmo
            Interface.exibirMensagemErro(titulo, "Ocorreu um erro: " + e + "\nVerifique o formato da entrada");
            return null;
        }
        
        
        return new Servico(descricao, preco, diasExecucao, horasExecucao, minutosExecucao, segundosExecucao);
    }
    
    // Utiliza um diálogo de entrada para receber o código e busca o serviço pelo código.
    // Se o código não for null (operação não ter sido cancelada), é buscado o serviço pelo código e se ele existir
    // (não for null) ele é exibido, senão é informado que o serviço não foi encontrado.
    public static void exibirConsultaCodigo() {
        String titulo = "Consultar por Código";
        String codigo;
        Servico servico;
        
        codigo = Interface.exibirDialogoEntrada(titulo, "Código: ");
        
        if (codigo != null) {
            servico = Oficina.buscarServico(Integer.parseInt(codigo));
            if (servico != null)
                Interface.exibirMensagem(titulo, servico.toString());
            else
                Interface.exibirMensagemErro(titulo, "Serviço não encontrado");
        }
    }
    
    // Utiliza um diálogo de entrada para receber o código e busca o serviço pelo código para excluí-lo.
    // Se o código não for null (operação não ter sido cancelada), é buscado o serviço pelo código e se ele existir
    // (não for null) ele é excluido chamando o método Oficina.excluirServico(int codigo).
    // O método excluirServico devolve um boolean representando o sucesso da operação, desta forma se devolver um
    // false é avisado que o cliente não foi encontrada para exclusão.
    public static void exibirExcluirServico() {
        String titulo = "Excluir Serviço";
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código: ");
        
        if (codigo != null)
            switch (Oficina.excluirServico(Integer.parseInt(codigo))) {
                case 0 -> Interface.exibirMensagem(titulo, "Serviço excluído com sucesso");
                case 1 -> Interface.exibirMensagemErro(titulo, "Serviço não encontrado para exclusão");
                case 2 -> Interface.exibirMensagemErro(titulo, "O serviço está presente em ordens de serviço");
            }
    }
    
    // Utiliza um diálogo para receber o código e busca o serviço pelo código para editá-lo
    // Se o código não for null (operação não ter sido cancelada), é buscado o serviço pelo código e se ele existir
    // (não for null) é exibido um menu para editar suas informações, este menu chama diálogos para receber entrada
    // e alterar os valores dos atributos do serviço.
    public static void exibirEditarServico() {
        String titulo = "Editar Cliente";
        String[] opcoes = {"Editar Descrição", "Editar Preço", "Editar Tempo de Execução", "Sair"};
        int opcao;
        String codigo;
        Servico servico;
        
        codigo = Interface.exibirDialogoEntrada(titulo, "Código do serviço a editar: ");
       
        if (codigo != null) {
             servico = Oficina.buscarServico(Integer.parseInt(codigo));
             if (servico != null)
             {
                 do {
                     opcao = Interface.exibirMenu(titulo, servico.toString(), opcoes);
                     switch (opcao) {
                         case 1 -> {
                             String descricao = Interface.exibirDialogoEntrada(titulo, "Nova descrição: ");
                             if (descricao != null) servico.setDescricao(descricao);
                         }

                         case 2 -> {
                             String preco = Interface.exibirDialogoEntrada(titulo, "Novo preço: ");
                             if (preco != null) servico.setPreco(Double.parseDouble(preco));
                         }
                         
                         case 3 -> {
                            int diasExecucao, horasExecucao, minutosExecucao, segundosExecucao;
                             
                            String tempoExecucao = Interface.exibirDialogoEntrada(titulo, "Novo tempo de execução (dd:hh:mm:ss): ");
                            if (tempoExecucao != null) {
                                try {
                                    diasExecucao = Integer.parseInt(tempoExecucao.split(":")[0]);
                                    horasExecucao = Integer.parseInt(tempoExecucao.split(":")[1]);
                                    minutosExecucao = Integer.parseInt(tempoExecucao.split(":")[2]);
                                    segundosExecucao = Integer.parseInt(tempoExecucao.split(":")[3]);
                                    servico.setTempoExecucao(diasExecucao, horasExecucao, minutosExecucao, segundosExecucao);
                                } catch (Exception e) {
                                    Interface.exibirMensagemErro(titulo, "Ocorreu um erro: " + e + "\nVerifique o formato da entrada");
                                } 
                            }
                         }
                     }
                 } while (!(opcao == 0 || opcao == 4)); // Enquanto não fechar a janela ou selecionar a opção 4
             } else {
                 Interface.exibirMensagemErro(titulo, "Serviço não encontrado");
             }
         }
    }
    
    public static void exibirListarServicos() {
        ArrayList<Servico> listaServicos = Oficina.getListaServicos();
        String mensagem = "";
            
        for(Servico servico : listaServicos)
            mensagem += servico + "\n";
        
        Interface.exibirMensagem("Listar Serviços", mensagem);
    }
}
