package classes;

import java.io.Serializable;

public class Cliente implements Serializable, Comparable<Cliente>{
    private String nome;
    private String cpf;
    private String endereco;
    private String fone;
    
    public Cliente (String nome, String cpf, String endereco, String fone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.fone = fone;
    }

    /* -- GETTERS E SETTERS -- */

    /* nome */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /* cpf */
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /* endereco */
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /* fone */
    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    @Override
    public String toString() {
        String saida = "";

        saida += "Nome: " + nome + "\n";
        saida += "CPF: " + cpf + "\n";
        saida += "Endereço: " + endereco + "\n";
        saida += "Telefone: " + fone + "\n";

        return saida;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.nome.compareTo(o.nome);
    }

}
