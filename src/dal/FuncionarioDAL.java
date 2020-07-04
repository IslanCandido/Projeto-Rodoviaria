package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Cargo;
import model.Endereco;
import model.Funcionario;
import util.Conexao;

public class FuncionarioDAL implements BasicoDAL<Funcionario> {
    private Connection conexao;
    
    public FuncionarioDAL() {
        conexao = Conexao.getConexao();
    }

    @Override
    public boolean adicionar(Funcionario funcionario) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO funcionarios (fun_nome, fun_cpf, fun_pis, fun_email, fun_dt_nascimento, fun_matricula, fun_telefone, fun_senha, fun_fk_car, fun_fk_end) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getPis());
            ps.setString(4, funcionario.getEmail());
            ps.setDate(5, new java.sql.Date(funcionario.getDtNascimento().getTime()));
            ps.setString(6, funcionario.getMatricula());
            ps.setString(7, funcionario.getTelefone());
            ps.setString(8, funcionario.getSenha());
            ps.setInt(9, funcionario.getIdCargo().getCodigo());
            ps.setInt(10, funcionario.getIdEndereco().getCodigo());
            
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!\n" + e);
        }
        return result;
    }

    @Override
    public boolean alterar(Funcionario funcionario) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE funcionarios SET fun_nome = ?, fun_cpf = ?, fun_pis = ?, fun_email = ?, fun_dt_nascimento = ?, fun_matricula = ?, fun_telefone = ?, fun_senha = ?, fun_fk_car = ?, fun_fk_end = ? WHERE fun_id = ?");
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getPis());
            ps.setString(4, funcionario.getEmail());
            ps.setDate(5, new java.sql.Date(funcionario.getDtNascimento().getTime()));
            ps.setString(6, funcionario.getMatricula());
            ps.setString(7, funcionario.getTelefone());
            ps.setString(8, funcionario.getSenha());
            ps.setInt(9, funcionario.getIdCargo().getCodigo());
            ps.setInt(10, funcionario.getIdEndereco().getCodigo());
            ps.setInt(11, funcionario.getCodigo());
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO EDITAR DADOS!");
        }
        return result;
    }

    @Override
    public boolean excluir(int id) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM funcionarios WHERE fun_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Funcionario> consultar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from funcionarios f\n"
                    + "inner join enderecos e on f.fun_fk_end = e.end_id \n"
                    + "inner join cargos cr on f.fun_fk_car = cr.car_id ");

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("fun_id"));
                funcionario.setNome(rs.getString("fun_nome"));
                funcionario.setCpf(rs.getString("fun_cpf"));
                funcionario.setPis(rs.getString("fun_pis"));
                funcionario.setEmail(rs.getString("fun_email"));
                funcionario.setDtNascimento(rs.getDate("fun_dt_nascimento"));
                funcionario.setMatricula(rs.getString("fun_matricula"));
                funcionario.setTelefone(rs.getString("fun_telefone"));
                funcionario.setSenha(rs.getString("fun_senha"));

                Cargo cargo = new Cargo();
                cargo.setCodigo(rs.getInt("car_id"));
                cargo.setDescricao(rs.getString("car_descricao"));
                cargo.setSalario(rs.getFloat("car_salario"));
                
                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("end_id"));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setUf(rs.getString("end_uf"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setComplemento(rs.getString("end_complemento"));                

                funcionario.setIdEndereco(endereco);
                funcionario.setIdCargo(cargo);

                funcionarios.add(funcionario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS!");
        }
        return funcionarios;
    }

    @Override
    public Funcionario consultarPorId(int id) {
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from funcionarios f\n"
                    + "inner join enderecos e on f.fun_fk_end = e.end_id \n"
                    + "inner join cargos cr on f.fun_fk_car = cr.car_id \n"
                    + "where f.fun_id = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                funcionario.setCodigo(rs.getInt("fun_id"));
                funcionario.setNome(rs.getString("fun_nome"));
                funcionario.setCpf(rs.getString("fun_cpf"));
                funcionario.setPis(rs.getString("fun_pis"));
                funcionario.setEmail(rs.getString("fun_email"));
                funcionario.setDtNascimento(rs.getDate("fun_dt_nascimento"));
                funcionario.setMatricula(rs.getString("fun_matricula"));
                funcionario.setTelefone(rs.getString("fun_telefone"));
                funcionario.setSenha(rs.getString("fun_senha"));

                Cargo cargo = new Cargo();
                cargo.setCodigo(rs.getInt("car_id"));
                cargo.setDescricao(rs.getString("car_descricao"));
                cargo.setSalario(rs.getFloat("car_salario"));
                
                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("end_id"));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setUf(rs.getString("end_uf"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setComplemento(rs.getString("end_complemento"));                

                funcionario.setIdEndereco(endereco);
                funcionario.setIdCargo(cargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return funcionario;
    }
    
    public Vector<Endereco> listarEnderecos() {
        Vector<Endereco> enderecos = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM enderecos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("end_id"));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setUf(rs.getString("end_uf"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setComplemento(rs.getString("end_complemento"));

                enderecos.add(endereco);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR ENDEREÇOS! ");
        }
        return enderecos;
    }
    
    public Vector<Cargo> listarCargos() {
        Vector<Cargo> cargos = new Vector<Cargo>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM cargos");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setCodigo(rs.getInt("car_id"));
                cargo.setDescricao(rs.getString("car_descricao"));
                cargo.setSalario(rs.getFloat("car_salario"));

                cargos.add(cargo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR CARGOS! ");
        }
        return cargos;
    }

    public boolean verificarPisIgual(String pis) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM funcionarios WHERE fun_pis = ?");
            preparedStatement.setString(1, pis);
            ResultSet rs = preparedStatement.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR PIS! ");
        }

        return resultado;
    }

    public boolean verificarCpfIgual(String cpf) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM funcionarios WHERE fun_cpf = ?");
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR CPFs! ");
        }

        return resultado;
    }
    
    public boolean autenticarUsuario(String usuario, String senha) {
        boolean resultado = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from funcionarios f\n"
                    + "inner join enderecos e on f.fun_fk_end = e.end_id \n"
                    + "inner join cargos cr on f.fun_fk_car = cr.car_id \n"
                    + "WHERE f.fun_cpf = ? AND f.fun_senha = ?");

            ps.setString(1, usuario);
            ps.setString(2, senha);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            resultado = rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO AUTENTICAR FUNCIONÁRIO NO BANCO!");
        }
        return resultado;
    }

    public boolean alterarSenha(String cpf, String senha) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("update funcionarios set fun_senha = ?\n"
                    + "WHERE fun_cpf = ?");
            ps.setString(1, senha);
            ps.setString(2, cpf);   
            
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR SENHA NO BANCO!");
        }
        return result;
    }
    
}
