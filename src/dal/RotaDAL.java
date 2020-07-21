package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Modelo;
import model.Onibus;
import model.Rota;
import util.Conexao;

public class RotaDAL implements BasicoDAL<Rota> {

    private Connection conexao;

    public RotaDAL() {
        conexao = Conexao.getConexao();
    }

    @Override
    public boolean adicionar(Rota rota) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO rotas (rot_data, rot_horario_partida, rot_horario_destino, rot_cidade_partida, rot_cidade_destino, rot_preco, rot_fk_oni) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setDate(1, new java.sql.Date(rota.getData().getTime()));
            ps.setTime(2, rota.getHorarioPartida());
            ps.setTime(3, rota.getHorarioDestino());
            ps.setString(4, rota.getCidadePartida());
            ps.setString(5, rota.getCidadeDestino());
            ps.setFloat(6, rota.getPreco());
            ps.setInt(7, rota.getIdOnibus().getCodigo());

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!");
        }
        return result;
    }

    @Override
    public boolean alterar(Rota rota) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE rotas SET rot_data = ?, rot_horario_partida = ?, rot_horario_destino = ?, rot_cidade_partida = ?, rot_cidade_destino = ?, rot_preco = ?, rot_fk_oni = ? WHERE rot_id = ?");
            ps.setDate(1, new java.sql.Date(rota.getData().getTime()));
            ps.setTime(2, rota.getHorarioPartida());
            ps.setTime(3, rota.getHorarioDestino());
            ps.setString(4, rota.getCidadePartida());
            ps.setString(5, rota.getCidadeDestino());
            ps.setFloat(6, rota.getPreco());
            ps.setInt(7, rota.getIdOnibus().getCodigo());
            ps.setInt(8, rota.getCodigo());

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
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM rotas WHERE rot_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Rota> consultar() {
        List<Rota> rotas = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from rotas r\n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id");

            while (rs.next()) {
                Rota rota = new Rota();
                rota.setCodigo(rs.getInt("rot_id"));
                rota.setData(rs.getDate("rot_data"));
                rota.setHorarioPartida(rs.getTime("rot_horario_partida"));
                rota.setHorarioDestino(rs.getTime("rot_horario_destino"));
                rota.setCidadePartida(rs.getString("rot_cidade_partida"));
                rota.setCidadeDestino(rs.getString("rot_cidade_destino"));
                rota.setPreco(rs.getFloat("rot_preco"));

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

                rota.setIdOnibus(onibus);

                rotas.add(rota);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS!");
        }
        return rotas;
    }

    @Override
    public Rota consultarPorId(int id) {
        Rota rota = new Rota();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from rotas r\n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id \n"
                    + "where r.rot_id = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rota.setCodigo(rs.getInt("rot_id"));
                rota.setData(rs.getDate("rot_data"));
                rota.setHorarioPartida(rs.getTime("rot_horario_partida"));
                rota.setHorarioDestino(rs.getTime("rot_horario_destino"));
                rota.setCidadePartida(rs.getString("rot_cidade_partida"));
                rota.setCidadeDestino(rs.getString("rot_cidade_destino"));
                rota.setPreco(rs.getFloat("rot_preco"));

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

                rota.setIdOnibus(onibus);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return rota;
    }

    public Vector<Onibus> listarOnibus() {
        Vector<Onibus> listOnibus = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from onibus o\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id\n"
                    + "where o.oni_situacao like'%Disponivel%'");
            ResultSet rs = ps.executeQuery();

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
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR OS ONIBUS!");
        }
        return listOnibus;
    }

    public Vector<String> listarCidades(String estado) {
        Vector<String> cidades = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("select c.cid_nome from cidades c\n"
                    + "where c.cid_uf = ?");

            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cidades.add(rs.getString("cid_nome"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR AS CIDADES!");
        }
        return cidades;
    }

    public String mostrarEstado(String cidade) {
        String estado = "";
        try {
            PreparedStatement ps = conexao.prepareStatement("select c.cid_uf from cidades c\n"
                    + "where c.cid_nome = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ps.setString(1, cidade);
            ResultSet rs = ps.executeQuery();
            rs.first();
            estado = rs.getString("cid_uf");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR O ESTADO!");
        }
        return estado;
    }
}
