/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1poo;
import javax.swing.JOptionPane;
/**
 *
 * @author joovitor
 */
public class Interface {
    
    
    public static String MenuPrincipal()
    {
        String saida="",opcao;
        
        saida +="1 - Gerencias cliente\n";
        saida +="2 - Gerencias peças\n";
        saida +="3 - Gerencias serviços\n";
        saida +="4 - Gerencias ordens de serviço\n";
        saida +="5 - Consultar total vendido em um periodo\n";
        saida +="6 - Sair do programa";
        
        opcao = JOptionPane.showInputDialog(saida);
        
        return opcao;
    }
    
    public static String MenuPrincipalOpcao1()
    {
        String saida="",opcao;
        
        saida +="1 - Cadastrar\n";
        saida +="2 - Consultar por CPF\n";
        saida +="3 - Excluir\n";
        saida +="4 - Editar\n";
        saida +="5 - Listar todos os cadastros\n";
        saida +="6 - Voltar";
        
        opcao = JOptionPane.showInputDialog(saida);
        
        return opcao;
    }
    
    public static String MenuPrincipalOpcao2ou3()
    {
        String saida="",opcao;
        
        saida +="1 - Cadastrar\n";
        saida +="2 - Consultar por código\n";
        saida +="3 - Excluir\n";
        saida +="4 - Editar\n";
        saida +="5 - Listar todos os cadastros\n";
        saida +="6 - Voltar";
        
        opcao = JOptionPane.showInputDialog(saida);
        
        return opcao;
    }
    
    public static String MenuPrincipalOpcao4()
    {
        String saida="",opcao;
        
        saida +="1 - Abrir nova ordem de serviço\n";
        saida +="2 - Gerenciar itens\n";
        saida +="3 - Cancelar\n";
        saida +="4 - Finalizar\n";
        saida +="5 - Excluir\n";
        saida +="6 - Listar todas as ordens\n";
        saida +="7 - Voltar";
        
        opcao = JOptionPane.showInputDialog(saida);
        
        return opcao;
    }
     
    public static String MenuOrdemServiçoOpcao2()
    {
        String saida="",opcao;
        
        saida +="1 - Adicionar peça\n";
        saida +="2 - Adicionar serviço\n";
        saida +="3 - Excluir peça\n";
        saida +="4 - Excluir serviço\n";
        saida +="5 - Consultar total\n";
        saida +="6 - Voltar";
        
        opcao = JOptionPane.showInputDialog(saida);
        
        return opcao;
    }
      
    public static void imprimeString(String string)
    {
        JOptionPane.showMessageDialog(null, string);
    }
}
