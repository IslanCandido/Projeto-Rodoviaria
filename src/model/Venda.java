package model;

public class Venda {
    private int codigo;
    private Rota idRota;
    private int assento;
    private FormaPagamento idFormaDePagamento;
    private Cliente idCliente;
    private String nomePassageiro;
    private String valor;

    public Venda() {
        idCliente = new Cliente();
        idFormaDePagamento = new FormaPagamento();
        idRota = new Rota();
    }

    public Venda(int codigo, Rota idRota, int assento, FormaPagamento idFormaDePagamento, Cliente idCliente, String nomePassageiro, String valor) {
        this.codigo = codigo;
        this.idRota = idRota;
        this.assento = assento;
        this.idFormaDePagamento = idFormaDePagamento;
        this.idCliente = idCliente;
        this.nomePassageiro = nomePassageiro;
        this.valor = valor;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Rota getIdRota() {
        return idRota;
    }

    public void setIdRota(Rota idRota) {
        this.idRota = idRota;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public FormaPagamento getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(FormaPagamento idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
