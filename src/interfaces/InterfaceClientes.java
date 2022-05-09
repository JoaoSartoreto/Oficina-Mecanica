package interfaces;

import classes.Cliente;
import java.util.ArrayList;
import oficina.Oficina;

public class InterfaceClientes {
    
    // Chama o método exibirMenuNumerado para exibir o menu de gerenciamento de clientes.
    // Devolve a opção selecionada (int).
    public static int exibir()
    {
        String mensagem = "";
        
        mensagem += "1 - Cadastrar\n";
        mensagem += "2 - Consultar por CPF\n";
        mensagem += "3 - Excluir\n";
        mensagem += "4 - Editar\n";
        mensagem += "5 - Listar todos os cadastros\n";
        mensagem += "6 - Voltar\n";
        
        return Interface.exibirMenuNumerado("Gerenciar Clientes", mensagem, 6);
    }

    // Chama diálogos de entrada para receber os atributos de um cliente e devolve um objeto Cliente.
    // Se em algum momento o diálogo de entrada for cancelado (devolver null) o método devolve null.
    // O método também chama um método da Oficina para verificar se o CPF inserido já foi cadastrado.
    public static Cliente exibirCadastroCliente()
    {
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
    
    public static void exibirConsultaCpf()
    {
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
}