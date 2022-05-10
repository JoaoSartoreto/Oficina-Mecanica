package interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import oficina.Oficina;

public class InterfacePrincipal {

    // Chama o método exibirMenuNumerado para exibir o menu principal.
    // Devolve a opção selecionada (int).
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
    
    public static void consultarTotalVendidoEmPeriodo()
    {
        String titulo = "Total vendido em um periodo";
        String periodoInicialString, periodoFinalString;
        
        periodoInicialString = Interface.exibirDialogoEntrada(titulo, "Informe a data inicial do periodo: ");
        if(periodoInicialString != null)
        {
            periodoFinalString = Interface.exibirDialogoEntrada(titulo, "Informe a data final do periodo: ");
            if(periodoFinalString!=null)
            {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate dataInicial = LocalDate.parse(periodoInicialString, formatador);
                LocalDate dataFinal = LocalDate.parse(periodoFinalString, formatador);
                String totalVendidoString;
                totalVendidoString = Oficina.totalVendidoPeriodo(dataInicial, dataFinal);
                Interface.exibirMensagem(titulo, "Total: "+totalVendidoString);
            }
        }
    }
}
