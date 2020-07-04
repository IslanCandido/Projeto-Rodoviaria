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
import model.Cliente;
import model.Endereco;
import util.Conexao;

public class ClienteDAL implements BasicoDAL<Cliente>{
    private Connection conexao;

    public ClienteDAL() {
        conexao = Conexao.getConexao();
    }

    @Override
    public boolean adicionar(Cliente cliente) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO clientes (cli_nome, cli_cpf, cli_email, cli_dt_nascimento, cli_telefone, cli_fk_end) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setDate(4, new java.sql.Date(cliente.getDtNascimento().getTime()));
            ps.setString(5, cliente.getTelefone());
            ps.setInt(6, cliente.getIdEndereco().getCodigo());
            
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!\n" + e);
        }
        return result;
    }

    @Override
    public boolean alterar(Cliente cliente) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE clientes SET cli_nome = ?, cli_cpf = ?, cli_email = ?, cli_dt_nascimento = ?, cli_telefone = ?, cli_fk_end = ? WHERE cli_id = ?");

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setDate(4, new java.sql.Date(cliente.getDtNascimento().getTime()));
            ps.setString(5, cliente.getTelefone());
            ps.setInt(6, cliente.getIdEndereco().getCodigo());
            ps.setInt(7, cliente.getCodigo());
            
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
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM clientes WHERE cli_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Cliente> consultar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from clientes cl \n"
                    + "inner join enderecos e on cl.cli_fk_end = e.end_id");

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cli_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setDtNascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTelefone(rs.getString("cli_telefone"));

                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("end_id"));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setUf(rs.getString("end_uf"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setComplemento(rs.getString("end_complemento"));

                cliente.setIdEndereco(endereco);

                clientes.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS!");
        }
        return clientes;
    }

    @Override
    public Cliente consultarPorId(int id) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from clientes cl \n"
                    + "inner join enderecos e on cl.cli_fk_end = e.end_id \n"
                    + "where cl.cli_id = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setCodigo(rs.getInt("cli_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setDtNascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTelefone(rs.getString("cli_telefone"));

                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("end_id"));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setUf(rs.getString("end_uf"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setComplemento(rs.getString("end_complemento"));

                cliente.setIdEndereco(endereco);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return cliente;
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
    
    public boolean verificarCpfIgual(String cpf) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM clientes WHERE cli_cpf = ?");
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR CPFs! ");
        }

        return resultado;
    }
}
