package model;

public class Modelo {
    private int codigo;
    private String descricao;
    private Marca idMarca;
    
    public Modelo() {
        idMarca = new Marca();
    }
    
    public Modelo(int codigo, String descricao, Marca idMarca) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.idMarca = idMarca;
    }
    
    @Override
    public String toString() {
       return getIdMarca()+ " - " +getDescricao(); 
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

}
