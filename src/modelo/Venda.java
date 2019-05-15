package modelo;

public class Venda {

    private int id;
    private int pedidoId;
    private String data;
    private float valorliquido;

    public Venda(int pedidoId, String data, float valorliquido) {
        this.pedidoId = pedidoId;
        this.data = data;
        this.valorliquido = valorliquido;
    }

    public Venda() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(float valorliquido) {
        this.valorliquido = valorliquido;
    }
}
