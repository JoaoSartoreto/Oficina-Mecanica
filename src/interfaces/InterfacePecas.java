package interfaces;

import classes.Peca;
import java.util.ArrayList;
import oficina.Oficina;

public class InterfacePecas {

    /*
    Chama o método exibir() de MenuItem passando "Peças" como o tipo de item
    para exibir o menu de gerenciamento de peças.
    Devolve a opção selecionada (int).
    */
    public static int exibir() {
        return InterfaceItem.exibir("Peças");
    }
    
    /*
    Chama diálogos de entrada para receber os atributos de uma peça e devolve um objeto Peca.
    Se em algum momento o diálogo de entrada for cancelado (devolver null) o método devolve null.
    */
    public static Peca exibirCadastrarPeca()
    {
        String titulo = "Cadastrar Peça";
        String descricao, stringPreco, stringQtdeEstoque;
        double preco;
        int qtdeEstoque;
        
        descricao = Interface.exibirDialogoEntrada(titulo, "Descrição: ");
        if (descricao == null) return null;
        
        stringPreco = Interface.exibirDialogoEntrada(titulo, "Preço: ");
        if (stringPreco == null) return null;
        preco = Double.parseDouble(stringPreco);
        
        stringQtdeEstoque = Interface.exibirDialogoEntrada(titulo, "Quantidade no estoque: ");
        if (stringQtdeEstoque == null) return null;
        qtdeEstoque = Integer.parseInt(stringQtdeEstoque);
              
        return new Peca(descricao,preco,qtdeEstoque);
    }
    
    /* 
    Utiliza um diálogo de entrada para receber o código da peça e busca a peça pelo código.
    Se o código não for null (operação não ter sido cancelada), é buscada a peça pelo código e se ela existir
    (não for null) ela é exibida, senão é informado que a peça não foi encontrada.
    */
    public static void exibirConsultarPeca()
    {
        String titulo = "Consultar por Código";
        String codPeca;
        
        codPeca = Interface.exibirDialogoEntrada(titulo, "Código da peça");
        
        if(codPeca != null) {
            Peca peca = Oficina.buscarPeca(Integer.parseInt(codPeca));
            if(peca != null)
                Interface.exibirMensagem(titulo, peca.toString());
            else
                Interface.exibirMensagemErro(titulo, "Peça não encontrada");
        }
    }
    
    /* 
    Utiliza um diálogo de entrada para receber o código da peça e busca busca a peça pelo código para excluí-la.
    Se o código não for null (operação não ter sido cancelada), é buscada a peça pelo código e se não ocorrer
    nenhum erro ela é excluída chamando o método Oficina.excluirPeca(int codPeca).
    O êxito da operação ou o erro que ocorreu é informado por uma mensagem.
    */
    public static void exibirExcluirPeca()
    {
        String titulo = "Excluir Peça";
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código da peça: ");
        
        if (codigo != null)
            switch (Oficina.excluirPeca(Integer.parseInt(codigo))) {
                case 0 -> Interface.exibirMensagem(titulo, "Peça excluída com sucesso");
                case 1 -> Interface.exibirMensagemErro(titulo, "Peça não encontrado para exclusão");
                case 2 -> Interface.exibirMensagemErro(titulo, "A peça está presente em ordens de serviço");
            }
    }
    
    /* 
    Utiliza um diálogo de entrada para receber o código da peça e busca a peça pelo código para editá-la.
    Se o código não for null (operação não ter sido cancelada), é buscada a peça pelo código e se ela existir
    (não for null) é exibido um menu para editar seus atributos, este menu chama diálogos para receber entrada
    e alterar os valores dos atributos da peça.
    */
    public static void exibirEditarPeca()
    { 
        String titulo = "Editar Peça";
        String[] opcoes = {"Editar Descrição", "Editar Preço", "Editar Quantidade em Estoque", "Sair"};
        int opcao;
        String codigo;
        Peca peca;
        
        codigo = Interface.exibirDialogoEntrada(titulo, "Código da peça a editar: ");
        if (codigo != null) {
            peca = Oficina.buscarPeca(Integer.parseInt(codigo));
            if (peca != null) {
                do {
                    opcao = Interface.exibirMenu(titulo, peca.toString(), opcoes);
                    switch (opcao) {
                        case 1 -> {
                            String descricao = Interface.exibirDialogoEntrada(titulo, "Nova descrição: ");
                            if (descricao != null) peca.setDescricao(descricao);
                        }

                        case 2 -> {
                            String preco = Interface.exibirDialogoEntrada(titulo, "Novo preço: ");
                            if (preco != null) peca.setPreco(Double.parseDouble(preco));
                        }

                        case 3 -> {
                            String qtdeEstoque = Interface.exibirDialogoEntrada(titulo, "Nova quantidade em estoque: ");
                            if (qtdeEstoque != null) peca.setQtdeEstoque(Integer.parseInt(qtdeEstoque));
                        }
                    }
                } while (!(opcao == 0 || opcao == 4)); // Enquanto não fechar a janela ou selecionar a opção 4
            } else {
                Interface.exibirMensagemErro(titulo, "Peça não encontrada");
            }
        }
    }
    
    /* Percorre a lista de peças para formar uma String com a lista e a exibe em uma mensagem */
    public static void exibirListarPecas()
    {
        ArrayList<Peca> pecas = Oficina.getListaPecas();
        String saida = "";
        
        for (Peca peca : pecas)
            saida += peca.toString() + "\n";
        
        Interface.exibirMensagem("Listar Peças", saida);
    }
}
