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
import model.Onibus;
import util.Conexao;

public class OnibusDAL implements BasicoDAL<Onibus> {

    private Connection conexao;

    public OnibusDAL() {
        conexao = Conexao.getConexao();
    }

    @Override
    public boolean adicionar(Onibus onibus) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO onibus (oni_placa, oni_renavam, oni_poltronas, oni_ano_fabricacao, oni_situacao, oni_fk_mod) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, onibus.getPlaca());
            ps.setString(2, onibus.getRenavam());
            ps.setInt(3, onibus.getNumeroDePoltronas());
            ps.setInt(4, onibus.getAnoDeFabricação());
            ps.setString(5, onibus.getSituacao());
            ps.setInt(6, onibus.getIdModelo().getCodigo());

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!");
        }
        return result;
    }

    @Override
    public boolean alterar(Onibus onibus) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE onibus SET oni_placa = ?, oni_renavam = ?, oni_poltronas = ?, oni_ano_fabricacao = ?, oni_situacao = ?, oni_fk_mod = ? WHERE oni_id = ?");
            ps.setString(1, onibus.getPlaca());
            ps.setString(2, onibus.getRenavam());
            ps.setInt(3, onibus.getNumeroDePoltronas());
            ps.setInt(4, onibus.getAnoDeFabricação());
            ps.setString(5, onibus.getSituacao());
            ps.setInt(6, onibus.getIdModelo().getCodigo());
            ps.setInt(7, onibus.getCodigo());

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
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM onibus WHERE oni_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Onibus> consultar() {
        List<Onibus> listOnibus = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from onibus o\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id ");

            while (rs.next()) {
                Onibus onibus = new Onibus();
                onibus.setCodigo(rs.getInt("oni_id"));
                onibus.setPlaca(rs.getString("oni_placa"));
                onibus.setRenavam(rs.getString("oni_renavam"));
                onibus.setNumeroDePoltronas(rs.getInt("oni_poltronas"));
                onibus.setAnoDeFabricação(rs.getInt("oni_ano_fabricacao"));
                onibus.setSituacao(rs.getString("oni_situacao"));

                Modelo modelo = new Modelo();
                modelo.setCodigo(rs.getInt("mod_id"));
                modelo.setDescricao(rs.getString("mod_descricao"));
                modelo.getIdMarca();

                onibus.setIdModelo(modelo);

                listOnibus.add(onibus);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS!");
        }
        return listOnibus;
    }

    @Override
    public Onibus consultarPorId(int id) {
        Onibus onibus = new Onibus();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from onibus o\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id \n"
                    + "where o.oni_id = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                onibus.setCodigo(rs.getInt("oni_id"));
                onibus.setPlaca(rs.getString("oni_placa"));
                onibus.setRenavam(rs.getString("oni_renavam"));
                onibus.setNumeroDePoltronas(rs.getInt("oni_poltronas"));
                onibus.setAnoDeFabricação(rs.getInt("oni_ano_fabricacao"));
                onibus.setSituacao(rs.getString("oni_situacao"));

                Modelo modelo = new Modelo();
                modelo.setCodigo(rs.getInt("mod_id"));
                modelo.setDescricao(rs.getString("mod_descricao"));
                modelo.getIdMarca();

                onibus.setIdModelo(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return onibus;
    }

    public List<Onibus> consultarDisponiveis() {
        List<Onibus> listOnibus = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from onibus o\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id \n"
                    + "where o.oni_situacao like'%Disponivel%'");

            while (rs.next()) {
                Onibus onibus = new Onibus();
                onibus.setCodigo(rs.getInt("oni_id"));
                onibus.setPlaca(rs.getString("oni_placa"));
                onibus.setRenavam(rs.getString("oni_renavam"));
                onibus.setNumeroDePoltronas(rs.getInt("oni_poltronas"));
                onibus.setAnoDeFabricação(rs.getInt("oni_ano_fabricacao"));
                onibus.setSituacao(rs.getString("oni_situacao"));

                Modelo modelo = new Modelo();
                modelo.setCodigo(rs.getInt("mod_id"));
                modelo.setDescricao(rs.getString("mod_descricao"));
                modelo.getIdMarca();

                onibus.setIdModelo(modelo);

                listOnibus.add(onibus);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS ÔNIBUS DISPONIVEIS! " + e);
        }
        return listOnibus;
    }
    
    public List<Onibus> consultarIndisponiveis() {
        List<Onibus> listOnibus = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from onibus o\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id \n"
                    + "where o.oni_situacao like'%Indisponivel%'");

            while (rs.next()) {
                Onibus onibus = new Onibus();
                onibus.setCodigo(rs.getInt("oni_id"));
                onibus.setPlaca(rs.getString("oni_placa"));
                onibus.setRenavam(rs.getString("oni_renavam"));
                onibus.setNumeroDePoltronas(rs.getInt("oni_poltronas"));
                onibus.setAnoDeFabricação(rs.getInt("oni_ano_fabricacao"));
                onibus.setSituacao(rs.getString("oni_situacao"));

                Modelo modelo = new Modelo();
                modelo.setCodigo(rs.getInt("mod_id"));
                modelo.setDescricao(rs.getString("mod_descricao"));
                modelo.getIdMarca();

                onibus.setIdModelo(modelo);

                listOnibus.add(onibus);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS ÔNIBUS INDISPONIVEIS! " + e);
        }
        return listOnibus;
    }
    
    public Vector<Modelo> listarModelos() {
        Vector<Modelo> modelos = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from modelos m \n"
                    + "inner join marcas ma on m.mod_fk_mar = ma.mar_id");
            ResultSet rs = ps.executeQuery();

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
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR MODELOS!");
        }
        return modelos;
    }
    
    public boolean verificarPlacaIgual(String placa) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM onibus WHERE oni_placa = ?");
            preparedStatement.setString(1, placa);
            ResultSet rs = preparedStatement.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR PLACAS!");
        }

        return resultado;
    }
    
    public boolean verificarRenavamIgual(String renavam) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM onibus WHERE oni_renavam = ?");
            preparedStatement.setString(1, renavam);
            ResultSet rs = preparedStatement.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR RENAVAM!");
        }

        return resultado;
    }

}
