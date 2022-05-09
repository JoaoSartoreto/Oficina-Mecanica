package interfaces;

import classes.Servico;

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
        } catch (NumberFormatException e) {
            Interface.exibirMensagemErro(titulo, "Ocorreu um erro: " + e + "\nVerifique o formato da entrada");
            return null;
        }
        
        return new Servico(descricao, preco, diasExecucao, horasExecucao, minutosExecucao, segundosExecucao);
    }
    
}
