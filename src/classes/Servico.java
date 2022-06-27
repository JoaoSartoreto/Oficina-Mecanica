package classes;

import excecoes.CampoVazioException;
import excecoes.produto.PrecoInvalidoException;
import java.text.DecimalFormat;
import java.time.Duration;

public class Servico extends Produto{
    private Duration tempoExecucao;
    
    public Servico(String descricao, double preco, int diasExecucao, int horasExecucao, int minutosExecucao, int segundosExecucao) throws PrecoInvalidoException, CampoVazioException{
        super(descricao, preco);
        setTempoExecucao(diasExecucao, horasExecucao, minutosExecucao, segundosExecucao);
    }
    
    /* -- GETTERS E SETTERS -- */
    
    /* tempoExecucao */
    public Duration getTempoExecucao() {
        return tempoExecucao;
    }
    
    /* 
    Pega as partes do tempo de execucação e as formata para formar uma String.
    */
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
        /* Instancia um Duration a partir dos dias e acrescenta as outras unidades de tempo */
        this.tempoExecucao = Duration.ofDays(diasExecucao);
        this.tempoExecucao = this.tempoExecucao.plusHours(horasExecucao);
        this.tempoExecucao = this.tempoExecucao.plusMinutes(minutosExecucao);
        this.tempoExecucao = this.tempoExecucao.plusSeconds(segundosExecucao);
    }
    
    /* -- OUTROS MÉTODOS -- */
    
    @Override
    public String toString() {
        
        String saida = super.toString();

        saida += "Tempo de Execução: (dd:hh:mm:ss): " + getTempoExecucaoString() + "\n";

        return saida;
    }
     
    @Override
        public int compareTo(Object o) {
        String[] este = ((Produto)this).getDescricao().split(" ");
        String[] outro = ((Produto)o).getDescricao().split(" ");
        
        return este[0].compareTo(outro[0]);
    }
    
}