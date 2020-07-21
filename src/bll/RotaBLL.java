package bll;

import dal.RotaDAL;
import java.util.List;
import java.util.Vector;
import model.Onibus;
import model.Rota;

public class RotaBLL {
    RotaDAL dal;
    
    public RotaBLL() {
        dal = new RotaDAL();
    }
    
    public boolean salvar(Rota rota) throws Exception {
        return dal.adicionar(rota);
    }

    public boolean editar(Rota rota) throws Exception {
        return dal.alterar(rota);
    }

    public boolean remover(Rota rota) throws Exception {
        return dal.excluir(rota.getCodigo());
    }
    
    public List<Rota> consultar(){
        return dal.consultar();
    }
     
    public Rota consultaPorId(int id){
        return dal.consultarPorId(id);
    } 
    
    public Vector<Onibus> listarOnibus(){
        return dal.listarOnibus();
    }
    
    public Vector<String> listarCidades(String estado){
        return dal.listarCidades(estado);
    }
    
    public String mostrarEstado(String cidade) {
        return dal.mostrarEstado(cidade);
    }
    
    public boolean isData(String data) {
        String[] dataparticionada = data.split("/");
        int dia = Integer.parseInt(dataparticionada[0]);
        int mes = Integer.parseInt(dataparticionada[1]);
        int ano = Integer.parseInt(dataparticionada[2]);
        boolean anoBissexto = ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;

        if (((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia >= 1 && dia <= 31))
                || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia >= 1 && dia <= 30))
                || ((mes == 2) && (anoBissexto) && (dia >= 1 && dia <= 29) && (ano >= 2020 && ano <= 2021))
                || ((mes == 2) && !(anoBissexto) && (dia >= 1 && dia <= 28) && (ano >= 2020 && ano <= 2021))) {

            return true;
        } else {
            return false;
        }
    }

    public boolean isHorario(String horario) {
        String[] horaparticionada = horario.split(":");
        int hora = Integer.parseInt(horaparticionada[0]);
        int minutos = Integer.parseInt(horaparticionada[1]);
        int segundos = Integer.parseInt(horaparticionada[2]);

        if ((hora >= 0 && hora <= 23) || (minutos >= 0 || minutos <= 59) || (segundos >= 0 && segundos <= 99)) {
            return true;
        } else {
            return false;
        }
    }
}
