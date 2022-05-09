package interfaces;

import classes.Peca;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oficina.Oficina;

public class InterfacePecas {

    // Chama o método exibir() de MenuItem passando "Peças" como o tipo de item para exibir o menu de gerenciamento de peças.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        return InterfaceItem.exibir("Peças");
    }
    
    // Aqui terá que utilizar Strings para verificar null também
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
    
    public static void exibirConsultarPeca()
    {
        String titulo = "Consultar por Código";
        String codPeca;
        
        codPeca = Interface.exibirDialogoEntrada(titulo, "Insira o código da peça");
        
        if(codPeca != null) {
            Peca peca = Oficina.buscarPeca(Integer.parseInt(codPeca));
            if(peca != null)
                Interface.exibirMensagem(titulo, peca.toString());
            else
                Interface.exibirMensagemErro(titulo, "Peça não encontrada");
        }
    }
    
    public static void exibirExcluirPeca()
    {
        String titulo = "Excluir Peça";
        String codigo = Interface.exibirDialogoEntrada(titulo, "Código: ");
        
        if(codigo != null && !Oficina.excluirPeca(Integer.parseInt(codigo)))
            Interface.exibirMensagemErro(titulo, "Peça não encontrada para exclusão"); 
    }
    
    // Tenho que verificar com mais atenção, mas aqui vai ter que usar Strings para verificar null
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
    
    public static void exibirListarPecas()
    {
        ArrayList<Peca> pecas = Oficina.getListaPecas();
        String saida = "";
        
        for (Peca peca : pecas)
            saida += peca.toString() + "\n";
        
        Interface.exibirMensagem("Listar Peças", saida);
    }
}
