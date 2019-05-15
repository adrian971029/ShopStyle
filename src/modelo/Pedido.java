package modelo;

public class Pedido {

    private int id;
    private int pessoaId;
    private float valor;
    private float desconto;
    private float valorliquido;

    public Pedido(int pessoaId, float valor, float desconto, float valorliquido) {
        this.pessoaId = pessoaId;
        this.valor = valor;
        this.desconto = desconto;
        this.valorliquido = valorliquido;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(float valorliquido) {
        this.valorliquido = valorliquido;
    }
}
