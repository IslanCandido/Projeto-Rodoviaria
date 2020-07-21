package bll;

import dal.VendaDAL;
import java.util.List;
import java.util.Vector;
import model.Cliente;
import model.FormaPagamento;
import model.Funcionario;
import model.Rota;
import model.Venda;

public class VendaBLL {

    VendaDAL dal;
    
    public VendaBLL() {
        dal = new VendaDAL();
    }
    
    public boolean salvar(Venda venda) throws Exception {
        return dal.adicionar(venda);
    }

    public boolean editar(Venda venda) throws Exception {
        return dal.alterar(venda);
    }

    public boolean remover(Venda venda) throws Exception {
        return dal.excluir(venda.getCodigo());
    }
    
    public List<Venda> consultar(){
        return dal.consultar();
    }
     
    public Venda consultaPorId(int id){
        return dal.consultarPorId(id);
    } 
    
    public Vector<Rota> listarRotas(){
        return dal.listarRotas();
    }
    
    public Vector<Funcionario> listarFuncionarios(){
        return dal.listarFuncionarios();
    }
    
    public Vector<Cliente> listarClientes(){
        return dal.listarClientes();
    }
    
    public Vector<FormaPagamento> listarFormasPagamento(){
        return dal.listarFormasPagamento();
    }
    
    public int nPoltronas(int id){
        return dal.pegarNPoltronas(id);
    }
    
    public float precoRota(int id){
        return dal.pegarPreco(id);
    }
    
    public boolean verificarAssentosIguais(int id, int assento){
        return dal.verificarAssentos(id, assento);
    }
}
