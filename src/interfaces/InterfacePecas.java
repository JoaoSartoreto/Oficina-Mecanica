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
        String descricao, precoString, qtdEstoqueString;
        double preco;
        int qtdEstoque;
        
        descricao = Interface.exibirDialogoEntrada(titulo, "Descrição da peça: ");
        if (descricao == null) return null;
        
        precoString = Interface.exibirDialogoEntrada(titulo, "Valor da peça: ");
        if(precoString != null)
        {
            preco = Double.parseDouble(precoString);
        }
        else
        {
            return null;
        }
        
        qtdEstoqueString = Interface.exibirDialogoEntrada(titulo, "Quantidade no estoque: ");
        if(qtdEstoqueString != null)
        {
            qtdEstoque = Integer.parseInt(qtdEstoqueString);
        }
        else
        {
           return null;
        }
        
        return new Peca(descricao,preco,qtdEstoque);
    }
    
    public static void exibirConsultarPeca()
    {
        String titulo = "Consulta de peça por código";
        String codPecaString;
        int codPeca;
        
        codPecaString = Interface.exibirDialogoEntrada(titulo, "Insira o código da peça");
        if(codPecaString!=null)
        {
            codPeca = Integer.parseInt(codPecaString);
            Peca peca = Oficina.buscarPeca(codPeca);
            if(peca!=null)
            {
                Interface.exibirMensagem(titulo, peca.toString());
            }
            else
            {
                Interface.exibirMensagemErro(titulo, "Peça não encontrada");
            }
        }
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
    
    public static void exibirExcluirPeca()
    {
        String indexString;
        int index;
        indexString = Interface.exibirDialogoEntrada("Excluir Peça", "Insira o índice da peça que deseja excluir");
        if(indexString != null)
        {
            index = Integer.parseInt(indexString);
            if(!Oficina.excluirPeca(index))
            {
                Interface.exibirMensagemErro(indexString, "Falha ao tentar excluir essa peça");
            }
        }
        
    }
    
    // Tenho que verificar com mais atenção, mas aqui vai ter que usar Strings para verificar null
    public static void exibirEditarPeca()
    { 
        String titulo = "Edição de peça";
        String codPecaString;
        int codPeca;
        
        codPecaString = Interface.exibirDialogoEntrada(titulo, "Informe o código da peça");
        if(codPecaString!=null)
        {
            codPeca = Integer.parseInt(codPecaString);
            Peca peca = Oficina.buscarPeca(codPeca);
            if(peca!=null)
            {
                String descricao;
                double preco;
                int qtdeEstoque;

                descricao = JOptionPane.showInputDialog("Descrição: ", peca.getDescricao());
                preco = Double.parseDouble(JOptionPane.showInputDialog("Preço: ", peca.getPreco()));
                qtdeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque: ",peca.getQtdeEstoque()));
                Oficina.editarPeca(codPeca, descricao, preco, qtdeEstoque);
            }
            else
            {
                Interface.exibirMensagemErro(titulo, "Peça não cadastrada");
            }
        }
              
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
