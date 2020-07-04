package bll;

import dal.MarcaDAL;
import java.util.List;
import model.Marca;

public class MarcaBLL {
    MarcaDAL dal;
    
    public MarcaBLL() {
        dal = new MarcaDAL();
    }
    
    public boolean salvar(Marca marca) throws Exception {
        return dal.adicionar(marca);
    }

    public boolean editar(Marca marca) throws Exception {
        return dal.alterar(marca);
    }

    public boolean remover(Marca marca) throws Exception {
        return dal.excluir(marca.getCodigo());
    }
    
     public List<Marca> consultar(){
        return dal.consultar();
    }
     
    public Marca consultaPorId(int id){
        return dal.consultarPorId(id);
    }
    
    public boolean verificarCargosIguais(String marca){
        return dal.verificarMarcaIgual(marca);
    }
    
}
