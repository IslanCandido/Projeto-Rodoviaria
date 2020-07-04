package model;

import java.sql.Date;

public class Cliente {
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private Date dtNascimento;
    private String telefone;
    private Endereco idEndereco;
        
    public Cliente(){
        idEndereco = new Endereco();
    }

    public Cliente(int codigo, String nome, String cpf, String email, Date dtNascimento, String telefone, Endereco idEndereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }
}
