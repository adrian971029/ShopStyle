package modelo;

public class Pessoa {

    private int id;
    private String nome;
    private String endereco;
    private String cep;
    private String email;
    private String senha;

    public Pessoa(String nome, String endereco, String cep, String email, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.senha = senha;
    }

    public Pessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
