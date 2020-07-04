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
import model.Marca;
import model.Modelo;
import util.Conexao;

public class ModeloDAL implements BasicoDAL<Modelo> {

    private Connection conexao;

    public ModeloDAL() {
        conexao = Conexao.getConexao();
    }

    @Override
    public boolean adicionar(Modelo modelo) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO modelos (mod_descricao, mod_fk_mar) VALUES (?, ?)");
            ps.setString(1, modelo.getDescricao());
            ps.setInt(2, modelo.getIdMarca().getCodigo());

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!");
        }
        return result;
    }

    @Override
    public boolean alterar(Modelo modelo) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE modelos SET mod_descricao = ?, mod_fk_mar = ? WHERE mod_id = ?");
            ps.setString(1, modelo.getDescricao());
            ps.setInt(2, modelo.getIdMarca().getCodigo());
            ps.setInt(3, modelo.getCodigo());

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
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM modelos WHERE mod_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Modelo> consultar() {
        List<Modelo> modelos = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from modelos m \n"
                    + "inner join marcas ma on m.mod_fk_mar = ma.mar_id");

            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setCodigo(rs.getInt("mod_id"));
                modelo.setDescricao(rs.getString("mod_descricao"));

                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("mar_id"));
                marca.setDescricao(rs.getString("mar_descricao"));

                modelo.setIdMarca(marca);

                modelos.add(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS! " + e);
        }
        return modelos;
    }

    @Override
    public Modelo consultarPorId(int id) {
        Modelo modelo = new Modelo();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from modelos m \n"
                    + "inner join marcas ma on m.mod_fk_mar = ma.mar_id \n"
                    + "where m.mod_id = ?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                modelo.setCodigo(rs.getInt("mod_id"));
                modelo.setDescricao(rs.getString("mod_descricao"));

                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("mar_id"));
                marca.setDescricao(rs.getString("mar_descricao"));

                modelo.setIdMarca(marca);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return modelo;
    }

    public Vector<Marca> listarMarcas() {
        Vector<Marca> marcas = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM marcas");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("mar_id"));
                marca.setDescricao(rs.getString("mar_descricao"));

                marcas.add(marca);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR MARCAS!");
        }
        return marcas;
    }

    public boolean verificarModeloIgual(String modelo) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM modelos WHERE mod_descricao = ?");
            preparedStatement.setString(1, modelo);
            ResultSet rs = preparedStatement.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR CARGOS!");
        }

        return resultado;
    }
}
