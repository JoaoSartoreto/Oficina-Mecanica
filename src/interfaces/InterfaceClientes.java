package interfaces;

import classes.Cliente;
import oficina.Oficina;

public class InterfaceClientes {
    
    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de clientes.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        String mensagem = "";
        
        mensagem += "1 - Cadastrar\n";
        mensagem += "2 - Consultar por CPF\n";
        mensagem += "3 - Excluir\n";
        mensagem += "4 - Editar\n";
        mensagem += "5 - Listar todos os cadastros\n";
        mensagem += "6 - Voltar\n";
        
        return Interface.exibirMenu("Gerenciar Clientes", mensagem, 6);
    }

    // Chama diálogos de entrada para receber os atributos de um cliente e devolve um objeto Cliente.
    // Se em algum momento o diálogo de entrada for cancelado (devolver null) o método devolve null.
    // O método também chama um método da Oficina para verificar se o CPF inserido já foi cadastrado.
    public static Cliente exibirCadastroCliente() {
        String titulo = "Cadastrar Cliente";
        String nome;
        String cpf;
        String endereco;
        String telefone;

        nome = Interface.exibirDialogoEntrada(titulo, "Nome: ");
        if (nome == null) return null;

        // Repete se o CPF inserido já estiver cadastrado.
        do {
            cpf = Interface.exibirDialogoEntrada(titulo, "CPF: ");    
            if (cpf == null) return null;

            if (Oficina.buscarCliente(cpf) != null) Interface.exibirMensagemErro(titulo, "Este CPF já está cadastrado");
        } while(Oficina.buscarCliente(cpf) != null);

        endereco = Interface.exibirDialogoEntrada(titulo, "Endereço: ");
        if (endereco == null) return null;

        telefone = Interface.exibirDialogoEntrada(titulo, "Telefone: ");
        if (telefone == null) return null;
        
        return new Cliente(nome, cpf, endereco, telefone);
    }
    
    // Utiliza um diálogo de entrada para receber o CPF e busca o cliente pelo CPF.
    // Se o CPF não for null (operação não ter sido cancelada), é buscado o cliente pelo CPF e se ele existir
    // (não for null) ele é exibido, senão é informado que o cliente não foi encontrado.
    public static void exibirConsultaCpf() {
        String titulo = "Consultar por CPF";
        String cpf;
        Cliente cliente;
        
        cpf = Interface.exibirDialogoEntrada(titulo, "CPF: ");
        
        if (cpf != null) {
            cliente = Oficina.buscarCliente(cpf);
            if (cliente != null)
            {
                Interface.exibirMensagem(titulo, cliente.toString());
            } else {
                Interface.exibirMensagemErro(titulo, "Cliente não encontrado");
            }
        }
    }
    
    // Utiliza um diálogo de entrada para receber o CPF e busca o cliente pelo CPF para excluí-lo.
    // Se o CPF não for null (operação não ter sido cancelada), é buscado o cliente pelo CPF e se ele existir
    // (não for null) ele é excluido chamando o método Oficina.excluirCliente(String cpf).
    // O método excluirCliente devolve um boolean representando o sucesso da operação, desta forma se devolver um
    // false é avisado que o cliente não foi encontrada para exclusão.
    public static void exibirExcluirCliente() {
        String titulo = "Excluir Cliente";
        String cpf;

        cpf = Interface.exibirDialogoEntrada(titulo, "CPF: ");
        
        if (cpf != null && !Oficina.excluirCliente(cpf)) 
            Interface.exibirMensagemErro(titulo, "Cliente não encontrado para exclusão");
    }
    
    // Utiliza um diálogo para receber o CPF e busca o cliente pelo CPF para editá-lo
    // Se o CPF não for null (operação não ter sido cancelada), é buscado o cliente pelo CPF e se ele existir
    // (não for null)  é exibido um menu para editar suas informações, este menu chama diálogos para receber entrada
    // e alterar os valores dos atributos do cliente.
    // O método altera apenas o endereço e o telefone porque são as únicas informações que se alteram de um cliente.
    public static void exibirEditarCliente() {
        String titulo = "Editar Cliente";
        String[] opcoes = {"Editar Endereço", "Editar Telefone", "Sair"};
        int opcao;
        String cpf;
        Cliente cliente;
        
       cpf = Interface.exibirDialogoEntrada(titulo, "CPF do cliente a editar: ");
       
       if (cpf != null) {
            cliente = Oficina.buscarCliente(cpf);
            if (cliente != null)
            {
                do {
                    opcao = Interface.exibirMenu(titulo, cliente.toString(), opcoes);
                    switch (opcao) {
                        case 1 -> {
                            String endereco = Interface.exibirDialogoEntrada(titulo, "Novo endereço: ");
                            if (endereco != null) cliente.setEndereco(endereco);
                        }
                        
                        case 2 -> {
                            String telefone = Interface.exibirDialogoEntrada(titulo, "Novo telefone: ");
                            if (telefone != null) cliente.setEndereco(telefone);
                        }
                    }
                } while (!(opcao == 0 || opcao == 3));
            } else {
                Interface.exibirMensagemErro(titulo, "Cliente não encontrado");
            }
        }
    }
                     
}