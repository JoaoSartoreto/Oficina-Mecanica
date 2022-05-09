package interfaces;

import classes.Peca;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        String descricao;
        double preco;
        int qtdEstoque;
        
        descricao = Interface.exibirDialogoEntrada(titulo, "Descrição da peça: ");
        if (descricao == null) return null;
        
        preco = Double.parseDouble(Interface.exibirDialogoEntrada(titulo, "Valor da peça: "));
        
        qtdEstoque = Integer.parseInt(Interface.exibirDialogoEntrada(titulo, "Quantidade no estoque: "));
        
        return null;
    }
    
    private static Peca exibirConsultarPeca(ArrayList<Peca> pecas, int codigo)
    {
        Peca pecaSearch = null;
        
        for (Peca peca : pecas) {
            if(peca.getCodPeca() == codigo)
            {
                pecaSearch = peca;
                return peca;
            }
        }
        return pecaSearch;
    }
    
    // Aparentemente este método é desnecessário
    /*
    public static void listarPecaPorCodigo(ArrayList<Peca> pecas)
    {
        String titulo = "Listar peça por código";
        int codigo;
        
        codigo = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Informe o código da peça que deseja listar: "));
        Peca peca = procurarPecaPorCodigo(pecas, codigo);
        if(peca != null)
        {
            Menu.exibirMensagem(titulo, peca.toString());
        }
        else
        {
            Menu.exibirMensagem(titulo, "Peça não encontrada");
        }
    }*/
    
    public static int exibirExcluirPeca(ArrayList<Peca> pecas)
    {
        return Integer.parseInt(Interface.exibirDialogoEntrada("Excluir Peça", "Insira o índice da peça que deseja excluir"));
    }
    
    // Tenho que verificar com mais atenção, mas aqui vai ter que usar Strings para verificar null
    public static void editarPeca(Peca peca)
    {   
        String descricao;
        double preco;
        int qtdeEstoque;
        
        descricao = JOptionPane.showInputDialog("Descrição: ", peca.getDescricao());
        preco = Double.parseDouble(JOptionPane.showInputDialog("Preço: ", peca.getPreco()));
        qtdeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque: ",peca.getQtdeEstoque()));
        
        peca.setDescricao(descricao);
        peca.setPreco(qtdeEstoque);
        peca.setQtdeEstoque(qtdeEstoque); 
    }
    
    public static void listarPecas(ArrayList<Peca> pecas)
    {
        String titulo = "Listar Peças";
        String saida ="";
        
        for (Peca peca : pecas) {
            saida += peca.toString();
        }
        Interface.exibirMensagem(titulo, saida);
    }
}
