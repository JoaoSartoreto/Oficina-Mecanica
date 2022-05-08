package menus;

import javax.swing.JOptionPane;

public abstract class Menu {
    
    private static final String NOME_PROGRAMA = "Controle de Oficina";

    // Concatena o título do menu com o nome do programa, cria um array com as opções numeradas de acordo
    // com a quantidade de opções e exibe um menu numerado.
    // Devolve a opção selecionada (int).
    protected static int exibirMenuNumerado(String titulo, String mensagem, int quantidadeOpcoes)
    {
        String tituloFinal = titulo + " - " + NOME_PROGRAMA;

        String[] opcoes = new String[quantidadeOpcoes];
        for (int i = 0; i < opcoes.length; i++)
            opcoes[i] = Integer.toString(i + 1);

        return JOptionPane.showOptionDialog(null, mensagem, tituloFinal , JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]) + 1;
    }

    // Concatena o título da mensagem, que será o título de menu que a chama, com o nome do programa 
    // e exibe um MessageDialog de erro.
    protected static void exibirMensagemErro(String titulo, String mensagem)
    {
        String tituloFinal = titulo + " - " + NOME_PROGRAMA;
        JOptionPane.showMessageDialog(null, mensagem, tituloFinal, JOptionPane.ERROR_MESSAGE);
    }

    // Concatena o título do menu com o nome do programa e exibe um diálogo de entrada.
    // O método vai repetir até que seja inserida uma entrada que não seja vazia, sempre avisando com uma mensagem de erro.
    // Se a entrada for cancelada devolverá null, senão devolverá uma String da entrada.
    protected static String exibirDialogoEntrada(String titulo, String mensagem)
    {
        String entrada;
        String tituloFinal = titulo + " - " + NOME_PROGRAMA;

        do {
            entrada = JOptionPane.showInputDialog(null, mensagem, tituloFinal, JOptionPane.PLAIN_MESSAGE);
            if (entrada != null && entrada.isBlank()) {
                exibirMensagemErro(titulo, "Este campo não pode estar vazio");
            }
        } while(entrada != null && entrada.isBlank());
        
        return entrada;
    }

    public static void imprimeString(String string)
    {
        JOptionPane.showMessageDialog(null, string);
    }
    
}
