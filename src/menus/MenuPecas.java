package menus;

import classes.Peca;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuPecas {

    // Chama o método exibir() de MenuItem passando "Peças" como o tipo de item para exibir o menu de gerenciamento de peças.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        return MenuItem.exibir("Peças");
    }
    
    public static Peca cadastrarPeca()
    {
        String titulo = "Cadastro de Peça";
        int codPeca;
        String descricao;
        double preco;
        int qtdeEstoque;
        
        codPeca = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Insira o código da peça: "));
        descricao = Menu.exibirDialogoEntrada(titulo, "Insira a descrição da peça: ");
        preco = Double.parseDouble(Menu.exibirDialogoEntrada(titulo, "Informe o valor da peça: "));
        qtdeEstoque = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Informe a quantidade no estoque: "));
        Peca peca = new Peca(codPeca, descricao, preco, qtdeEstoque);
        return peca;
    }
    
    private static Peca procurarPecaPorCodigo(ArrayList<Peca> pecas, int codigo)
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
    
    public static void listarPecaPorCodigo(ArrayList<Peca> pecas)
    {
        String titulo = "Listar peça por código";
        int codigo;
        
        codigo = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Informe o código da peça que deseja listar: "));
        Peca peca = procurarPecaPorCodigo(pecas, codigo);
        if(peca != null)
        {
            Menu.imprimeString(titulo, peca.toString());
        }
        else
        {
            Menu.imprimeString(titulo, "Peça não encontrada");
        }
    }
    
    public static void excluirPeca(ArrayList<Peca> pecas)
    {
        String titulo = "Exclusão de peça";
        int index;
        
        index = Integer.parseInt(Menu.exibirDialogoEntrada(titulo, "Informe o index da peça que deseja excluir: "));
        pecas.remove(index);
        Menu.imprimeString(titulo, "Peça excluida com sucesso");
    }
    
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
        String titulo = "Listagem de peças";
        String saida ="";
        
        for (Peca peca : pecas) {
            saida += peca.toString();
        }
        Menu.imprimeString(titulo, saida);
    }
}
