package modelo;

public class Fornecedor extends Pessoa {

    private int id;
    private int pessoaId;
    private String cnpj;
    private String razao;

    public Fornecedor(int pessoaId, String cnpj, String razao) {
        this.pessoaId = pessoaId;
        this.cnpj = cnpj;
        this.razao = razao;
    }

    public Fornecedor() {
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }
}
