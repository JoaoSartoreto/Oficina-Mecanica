package menus;

import javax.swing.JOptionPane;

public abstract class Menu {
    
    private static final String nomePrograma = "Controle de Oficina";

    protected static int menuOpcoesNumeradas(String titulo, String mensagem, int quantidadeOpcoes)
    {
        String tituloFinal = titulo + " - " + nomePrograma;

        String[] opcoes = new String[quantidadeOpcoes];
        for (int i = 0; i < opcoes.length; i++) {
            opcoes[i] = Integer.toString(i + 1);
        }

        return JOptionPane.showOptionDialog(null, mensagem, tituloFinal , JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]) + 1;
    }

      
    public static void imprimeString(String string)
    {
        JOptionPane.showMessageDialog(null, string);
    }
}
