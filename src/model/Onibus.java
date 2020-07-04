package model;

public class Onibus {
    private int codigo;
    private String placa;
    private String renavam;
    private int nPoltronas;
    private int anoDeFabricação;
    private String situacao;
    private Modelo idModelo;
        
    public Onibus(){
        idModelo = new Modelo();
    }
    
    public Onibus(int codigo, String placa, String renavam, int numeroDePoltronas, int anoDeFabricação, String situacao ,Modelo idModelo){
        this.codigo = codigo;
        this.placa = placa;
        this.renavam = renavam;
        this.nPoltronas = numeroDePoltronas;
        this.anoDeFabricação = anoDeFabricação;
        this.situacao = situacao;
        this.idModelo = idModelo; 
    }

    @Override
    public String toString() {
        return getPlaca() + " - " + getIdModelo().getDescricao();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroDePoltronas() {
        
        return nPoltronas;
    }

    public void setNumeroDePoltronas(int numeroDePoltronas) {
        
        this.nPoltronas = numeroDePoltronas;
    }

    public int getAnoDeFabricação() {
        return anoDeFabricação;
    }

    public void setAnoDeFabricação(int anoDeFabricação) {
        this.anoDeFabricação = anoDeFabricação;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }  
    
}
