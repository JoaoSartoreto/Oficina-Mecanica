package classes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;

public class Servico {
    private static int qtdeServicos;
    
    private int codServico;
    private String descricao;
    private double preco;
    private Duration tempoExecucao;
    
    public Servico(String descricao, double preco, int diasExecucao, int horasExecucao, int minutosExecucao, int segundosExecucao){
        qtdeServicos++;
        this.codServico = qtdeServicos;
        this.descricao = descricao;
        this.preco = preco;
        setTempoExecucao(diasExecucao, horasExecucao, minutosExecucao, segundosExecucao);
    }
    
    // GETTERS E SETTERS
    
    // codServico
    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    // descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // preco
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // tempoExecucao
    public Duration getTempoExecucao() {
        return tempoExecucao;
    }
    
    // Pega as partes do tempo de execucação para formar uma String.
    public String getTempoExecucaoString() {
        DecimalFormat formatador = new DecimalFormat();
        formatador.setMinimumIntegerDigits(2);
        
        String saida = "";

        saida += formatador.format(tempoExecucao.toDaysPart()) + ":";
        saida += formatador.format(tempoExecucao.toHoursPart()) + ":";
        saida += formatador.format(tempoExecucao.toMinutesPart()) + ":";
        saida += formatador.format(tempoExecucao.toSecondsPart());

        return saida;
    }

    public void setTempoExecucao(Duration tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }
    
    public final void setTempoExecucao(int diasExecucao, int horasExecucao, int minutosExecucao, int segundosExecucao) {
        // Instancia um Duration a partir dos dias e acrescenta as outras unidades de tempo
        this.tempoExecucao = Duration.ofDays(diasExecucao);
        this.tempoExecucao = this.tempoExecucao.plusHours(horasExecucao);
        this.tempoExecucao = this.tempoExecucao.plusMinutes(minutosExecucao);
        this.tempoExecucao = this.tempoExecucao.plusSeconds(segundosExecucao);
    }
    
    // OUTROS MÉTODOS
    
    @Override
    public String toString() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String saida = "";

        saida += "Código: " + codServico + "\n";
        saida += "Descrição: " + descricao + "\n";
        saida += "Preço: " + formatador.format(preco) + "\n";
        saida += "Tempo de Execução: (dd:hh:mm:ss): " + getTempoExecucaoString() + "\n";

        return saida;
    }
        
}