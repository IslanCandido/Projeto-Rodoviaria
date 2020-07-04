package bll;

import dal.ModeloDAL;
import java.util.List;
import java.util.Vector;
import model.Marca;
import model.Modelo;

public class ModeloBLL {
    ModeloDAL dal;
    
    public ModeloBLL() {
        dal = new ModeloDAL();
    }
    
    public boolean salvar(Modelo modelo) throws Exception {
        return dal.adicionar(modelo);
    }

    public boolean editar(Modelo modelo) throws Exception {
        return dal.alterar(modelo);
    }

    public boolean remover(Modelo modelo) throws Exception {
        return dal.excluir(modelo.getCodigo());
    }
    
     public List<Modelo> consultar(){
        return dal.consultar();
    }
     
    public Modelo consultaPorId(int id){
        return dal.consultarPorId(id);
    }
    
    public Vector<Marca> listarMarcas(){
        return dal.listarMarcas();
    }
    
    public boolean verificarModelosIguais(String modelo){
        return dal.verificarModeloIgual(modelo);
    }
}
