package classes;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;

public class Servico {
    private int codServico;
    private String descricao;
    private double preco;
    private Duration tempoExecucao;
    
    public Servico(int codServico, String descricao, double preco, int diasExecucao, int horasExecucao, int minutosExecucao, int segundosExecucao){
        this.codServico = codServico;
        this.descricao = descricao;
        this.preco = preco;
        
        // Instancia um Duration a partir dos dias e acrescenta as outras unidades de tempo
        this.tempoExecucao = Duration.ofDays(diasExecucao);
        this.tempoExecucao = this.tempoExecucao.plusHours(horasExecucao);
        this.tempoExecucao = this.tempoExecucao.plusMinutes(minutosExecucao);
        this.tempoExecucao = this.tempoExecucao.plusSeconds(segundosExecucao);
    }
    
    // GETTERS E SETTERS
    
    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Duration getTempoExecucao() {
        return tempoExecucao;
    }
    
    public String getTempoExecucaoString() {
        String saida = "";
        saida += tempoExecucao.toDaysPart() + ":";
        saida += tempoExecucao.toHoursPart() + ":";
        saida += tempoExecucao.toMinutesPart() + ":";
        saida += tempoExecucao.toSecondsPart();
        return saida;
    }

    public void setTempoExecucao(Duration tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }
    
    // OUTROS MÉTODOS
    
    @Override
    public String toString() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        
        String saida = "";
        saida += "Código: " + codServico + "\n";
        saida += "Descrição: " + descricao + "\n";
        saida += "Preço: " + formatador.format(preco) + "\n";
        saida += "Duração (dd:hh:mm:ss): " + getTempoExecucaoString() + "\n";
        return saida;
    }
        
}
