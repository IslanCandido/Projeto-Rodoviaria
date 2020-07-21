package model;

public class Venda {
    private int codigo;
    private Rota idRota;
    private int assento;
    private FormaPagamento idFormaDePagamento;
    private Funcionario idFuncionario;
    private Cliente idCliente;
    private String nomePassageiro;
    private float valor;
    private String situacao;

    public Venda() {
        idCliente = new Cliente();
        idFormaDePagamento = new FormaPagamento();
        idRota = new Rota();
        idFuncionario = new Funcionario();
    }

    public Venda(int codigo, Rota idRota, int assento, FormaPagamento idFormaDePagamento, Funcionario idFuncionario, Cliente idCliente, String nomePassageiro, float valor, String situacao) {
        this.codigo = codigo;
        this.idRota = idRota;
        this.assento = assento;
        this.idFormaDePagamento = idFormaDePagamento;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.nomePassageiro = nomePassageiro;
        this.valor = valor;
        this.situacao = situacao;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
