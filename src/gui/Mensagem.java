package gui;

import javax.swing.JOptionPane;

public class Mensagem {
    private static final String nomePrograma = "Controle de Oficina";
    
    public static void exibirMensagemErro(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo + " - " + nomePrograma, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void exibirMensagem(String titulo, String mensagem) {
       JOptionPane.showMessageDialog(null, mensagem, titulo + " - " + nomePrograma, JOptionPane.PLAIN_MESSAGE);
    }
}
