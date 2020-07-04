package model;

import java.sql.Date;
import java.sql.Time;

public class Rota {
    private int codigo;
    private Date data;
    private Time horarioPartida;
    private Time horarioDestino;
    private String cidadePartida;
    private String cidadeDestino;
    private float preco;
    private Onibus idOnibus;
        
    public Rota(){
        idOnibus = new Onibus();
    }

    public Rota(int codigo, Date data, Time horarioPartida, Time horarioDestino, String cidadePartida, String cidadeDestino, float preco, Onibus idOnibus) {
        this.codigo = codigo;
        this.data = data;
        this.horarioPartida = horarioPartida;
        this.horarioDestino = horarioDestino;
        this.cidadePartida = cidadePartida;
        this.cidadeDestino = cidadeDestino;
        this.preco = preco;
        this.idOnibus = idOnibus;
    }

    @Override
    public String toString() {
        return getData() + " - " + getCidadePartida() + " as " + getHorarioDestino() + " - de " + getCidadePartida() + " até " + getCidadeDestino();
    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorarioPartida() {
        return horarioPartida;
    }

    public void setHorarioPartida(Time horarioPartida) {
        this.horarioPartida = horarioPartida;
    }

    public Time getHorarioDestino() {
        return horarioDestino;
    }

    public void setHorarioDestino(Time horarioDestino) {
        this.horarioDestino = horarioDestino;
    }

    public String getCidadePartida() {
        return cidadePartida;
    }

    public void setCidadePartida(String cidadePartida) {
        this.cidadePartida = cidadePartida;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Onibus getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(Onibus idOnibus) {
        this.idOnibus = idOnibus;
    }
    
    
}
