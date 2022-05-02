package classes;

public class Cliente {
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

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
}
