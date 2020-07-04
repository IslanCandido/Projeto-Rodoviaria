package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Marca;
import util.Conexao;

public class MarcaDAL implements BasicoDAL<Marca>{
    private Connection conexao;

    public MarcaDAL() {
        conexao = Conexao.getConexao();
    }

    @Override
    public boolean adicionar(Marca marca) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement
            ("INSERT INTO marcas (mar_descricao) VALUES (?)");
            ps.setString(1, marca.getDescricao());
            
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!");
        }
        return result;
    }

    @Override
    public boolean alterar(Marca marca) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement
            ("UPDATE marcas SET mar_descricao = ? WHERE mar_id = ?");
            ps.setString(1, marca.getDescricao());
            ps.setInt(2, marca.getCodigo());
            
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
            PreparedStatement ps = conexao.prepareStatement
            ("DELETE FROM marcas WHERE mar_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Marca> consultar() {
        List<Marca> marcas = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM marcas");
            while (rs.next()){
                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("mar_id"));
                marca.setDescricao(rs.getString("mar_descricao"));
                
                marcas.add(marca);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS!");
        }
        return marcas;
    }
    
    @Override
    public Marca consultarPorId(int id) {
        Marca marca = new Marca();
        try {
            PreparedStatement ps = conexao.prepareStatement
            ("SELECT * FROM marcas WHERE mar_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                marca.setCodigo(rs.getInt("mar_id"));
                marca.setDescricao(rs.getString("mar_descricao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return marca;
    }
    
    public boolean verificarMarcaIgual(String marca) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM marcas WHERE mar_descricao = ?");
            preparedStatement.setString(1, marca);
            ResultSet rs = preparedStatement.executeQuery();            
            
            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR CARGOS!");
        }

        return resultado;
    }
}
