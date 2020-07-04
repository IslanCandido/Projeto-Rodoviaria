package bll;

import dal.OnibusDAL;
import java.util.List;
import java.util.Vector;
import model.Modelo;
import model.Onibus;

public class OnibusBLL {
    OnibusDAL dal;
    
    public OnibusBLL() {
        dal = new OnibusDAL();
    }
    
    public boolean salvar(Onibus onibus) throws Exception {
        return dal.adicionar(onibus);
    }

    public boolean editar(Onibus onibus) throws Exception {
        return dal.alterar(onibus);
    }

    public boolean remover(Onibus onibus) throws Exception {
        return dal.excluir(onibus.getCodigo());
    }
    
    public List<Onibus> consultar(){
        return dal.consultar();
    }
     
    public Onibus consultaPorId(int id){
        return dal.consultarPorId(id);
    }
    
    public List<Onibus> consultarDisponiveis(){
        return dal.consultarDisponiveis();
    } 
    
    public List<Onibus> consultarIndisponiveis(){
        return dal.consultarIndisponiveis();
    } 
    
    public Vector<Modelo> listarModelos(){
        return dal.listarModelos();
    }
    
    public boolean verificarPlacaIguais(String placa){
        return dal.verificarPlacaIgual(placa);
    }
    
    public boolean verificarRenavamIguais(String renavam){
        return dal.verificarRenavamIgual(renavam);
    }
    
    public boolean isRenavam(String renavam) {
        if (renavam == null || renavam.trim().length() != 9) {
            return false;
        }

        int calc = 0;
        int digito = Integer.parseInt(renavam.substring(8, 9));

        for (int i = 0; i < renavam.length() - 1; i++) {
            calc += Integer.parseInt(renavam.substring(i, i + 1)) * (i + 2);
        }

        return (calc % 11 == digito || calc % 11 == 0);
    }
}
