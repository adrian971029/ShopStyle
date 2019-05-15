package modelo;

public class Cliente extends Pessoa {

    private int id;
    private int pessoaId;
    private String cpf;

    public Cliente( int pessoaId, String cpf) {
        this.pessoaId = pessoaId;
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
