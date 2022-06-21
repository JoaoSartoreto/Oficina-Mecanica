package interfaces;

import java.text.NumberFormat;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import oficina.Oficina;

public class InterfacePrincipal {

    /* 
    Chama o método exibirMenuNumerado para exibir o menu principal.
    Devolve a opção selecionada (int).
    */
    public static int exibir()
    {
        String mensagem = "";
        
        mensagem += "1 - Gerenciar clientes\n";
        mensagem += "2 - Gerenciar peças\n";
        mensagem += "3 - Gerenciar serviços\n";
        mensagem += "4 - Gerenciar ordens de serviço\n";
        mensagem += "5 - Consultar total vendido em um período\n";
        mensagem += "6 - Sair do programa\n";
        
        return Interface.exibirMenu("Menu Principal", mensagem, 6);
    }
    
    /*
    Utiliza diálogos para receber a data de início e a data final do período.
    Essas datas são enviadas para o método Oficina.getTotalVendidoPeriodo que devolverá
    o total vendido nesse período, esse total é formatado e exibido em uma mensagem.
    */
    public static void consultarTotalVendidoEmPeriodo()
    {
        String titulo = "Total Vendido em um Período";
        String dataInicio, dataFinal;
        
        dataInicio = Interface.exibirDialogoEntrada(titulo, "Data inicial do período: ");
        if (dataInicio == null) return;
        
        dataFinal = Interface.exibirDialogoEntrada(titulo, "Data final do período: ");
        if (dataFinal == null) return;
        
        try {
            NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
            Interface.exibirMensagem(titulo, "Total: " + formatador.format(Oficina.getTotalVendidoPeriodo(dataInicio, dataFinal)));
        } catch (DateTimeParseException e) {
            Interface.exibirMensagemErro(titulo, "Data inválida");
        }
    }
}
