package interfaces;

import javax.swing.JOptionPane;

public class Interface {
    
    private static final String NOME_PROGRAMA = "Controle de Oficina";
    
    /*
    Concatena o título do menu com o nome do programa para ser o título da janela e exibe um menu com as opções
    Devolve a opção selecionada (int).
    */
    protected static int exibirMenu (String titulo, String mensagem, String[] opcoes)
    {
        String tituloFinal = titulo + " - " + NOME_PROGRAMA;
        return JOptionPane.showOptionDialog(null, mensagem, tituloFinal , JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]) + 1;
    }
    
    /*
    Cria um array com as opções numeradas de acordo com a quantidade de opções e exibe um menu numerado.
    Devolve a opção selecionada (int).
    */
    protected static int exibirMenu(String titulo, String mensagem, int quantidadeOpcoes)
    {
        String[] opcoes = new String[quantidadeOpcoes];
        for (int i = 0; i < opcoes.length; i++)
            opcoes[i] = Integer.toString(i + 1);

        return exibirMenu(titulo, mensagem, opcoes);
    }
    
    /*
    Concatena o título, que será o título do menu que a chama, com o nome do programa para ser o título
    da janela e exibe um MessageDialog de erro.   
    */
    public static void exibirMensagemErro(String titulo, String mensagem)
    {
        String tituloFinal = titulo + " - " + NOME_PROGRAMA;
        JOptionPane.showMessageDialog(null, mensagem, tituloFinal, JOptionPane.ERROR_MESSAGE);
    }
    
    /*
    Concatena o título, que será o título do menu que a chama, com o nome do programa para ser o título
    da janela e exibe um diálogo de entrada.
    O diálogo vai repetir até que seja inserida uma entrada que não seja vazia, sempre avisando com uma mensagem de erro.
    Se a entrada for cancelada devolverá null, senão devolverá uma String da entrada.
    */
    public static String exibirDialogoEntrada(String titulo, String mensagem)
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
    
    /*
    Concatena o título, que será o título do menu que a chama, com o nome do programa para ser o título
    da janela e exibe um MessageDialog.
    */
    public static void exibirMensagem(String titulo,String mensagem)
    {
        String tituloFinal =  titulo + " - " + NOME_PROGRAMA;
        JOptionPane.showMessageDialog(null, mensagem, tituloFinal, JOptionPane.PLAIN_MESSAGE);
    }
    
}
