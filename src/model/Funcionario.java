package model;

import java.sql.Date;

public class Funcionario {
    private int codigo;
    private String nome;
    private String cpf;
    private String pis;
    private String email;
    private Date dtNascimento;
    private String matricula;
    private String telefone;
    private Endereco idEndereco;
    private Cargo idCargo;
    private String senha;

    public Funcionario() {
        idEndereco = new Endereco();
        idCargo = new Cargo();
    }

    public Funcionario(int codigo, String nome, String cpf, String pis, String email, Date dtNascimento, String matricula, String telefone, Endereco idEndereco, Cargo idCargo, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.pis = pis;
        this.email = email;
        this.dtNascimento = dtNascimento;
        this.matricula = matricula;
        this.telefone = telefone;
        this.idEndereco = idEndereco;
        this.idCargo = idCargo;
        this.senha = senha;
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

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }
    
    
}
