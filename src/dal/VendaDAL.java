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
import model.Cliente;
import model.FormaPagamento;
import model.Funcionario;
import model.Modelo;
import model.Onibus;
import model.Rota;
import model.Venda;
import util.Conexao;

public class VendaDAL implements BasicoDAL<Venda> {

    private Connection conexao;

    public VendaDAL() {
        conexao = Conexao.getConexao();

    }

    @Override
    public boolean adicionar(Venda venda) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO vendas (ven_fk_rot, ven_assento, ven_fk_fun, ven_fk_cli, ven_nome_passageiro, ven_valor, ven_fk_pag, ven_situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, venda.getIdRota().getCodigo());
            ps.setInt(2, venda.getAssento());
            ps.setInt(3, venda.getIdFuncionario().getCodigo());
            ps.setInt(4, venda.getIdCliente().getCodigo());
            ps.setString(5, venda.getNomePassageiro());
            ps.setFloat(6, venda.getValor());
            ps.setInt(7, venda.getIdFormaDePagamento().getCodigo());
            ps.setString(8, venda.getSituacao());

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR DADOS!");
        }
        return result;
    }

    @Override
    public boolean alterar(Venda venda) {
        boolean result = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE vendas SET ven_fk_rot = ?, ven_assento = ?, ven_fk_fun = ?, ven_fk_cli = ?, ven_nome_passageiro = ?, ven_valor = ?, ven_fk_pag = ?, ven_situacao = ? WHERE ven_id = ?");
            ps.setInt(1, venda.getIdRota().getCodigo());
            ps.setInt(2, venda.getAssento());
            ps.setInt(3, venda.getIdFuncionario().getCodigo());
            ps.setInt(4, venda.getIdCliente().getCodigo());
            ps.setString(5, venda.getNomePassageiro());
            ps.setFloat(6, venda.getValor());
            ps.setInt(7, venda.getIdFormaDePagamento().getCodigo());
            ps.setString(8, venda.getSituacao());
            ps.setInt(9, venda.getCodigo());

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
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM vendas WHERE ven_id = ?");
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO REMOVER DADOS!");
        }
        return result;
    }

    @Override
    public List<Venda> consultar() {
        List<Venda> vendas = new ArrayList<>();
        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery("select * from vendas v\n"
                    + "inner join rotas r on v.ven_fk_rot = r.rot_id \n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id \n"
                    + "inner join funcionarios f on v.ven_fk_fun = f.fun_id \n"
                    + "inner join clientes c on v.ven_fk_cli = c.cli_id \n"
                    + "inner join formas_pagamento p on v.ven_fk_pag = p.pag_id ");

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigo(rs.getInt("ven_id"));
                venda.setAssento(rs.getInt("ven_assento"));
                venda.setNomePassageiro(rs.getString("ven_nome_passageiro"));
                venda.setValor(rs.getFloat("ven_valor"));
                venda.setSituacao(rs.getString("ven_situacao"));

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
                onibus.getIdModelo();

                rota.setIdOnibus(onibus);

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
                funcionario.getIdEndereco();
                funcionario.getIdCargo();

                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cli_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setDtNascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.getIdEndereco();

                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setCodigo(rs.getInt("pag_id"));
                formaPagamento.setFormaPagamento(rs.getString("pag_descricao"));

                venda.setIdRota(rota);
                venda.setIdFuncionario(funcionario);
                venda.setIdCliente(cliente);
                venda.setIdFormaDePagamento(formaPagamento);

                vendas.add(venda);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR TODOS OS DADOS!");
        }
        return vendas;
    }

    @Override
    public Venda consultarPorId(int id) {
        Venda venda = new Venda();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from vendas v\n"
                    + "inner join rotas r on v.ven_fk_rot = r.rot_id \n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id \n"
                    + "inner join funcionarios f on v.ven_fk_fun = f.fun_id \n"
                    + "inner join clientes c on v.ven_fk_cli = c.cli_id \n"
                    + "inner join formas_pagamento p on v.ven_fk_pag = p.pag_id \n"
                    + "where v.ven_id = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                venda.setCodigo(rs.getInt("ven_id"));
                venda.setAssento(rs.getInt("ven_assento"));
                venda.setNomePassageiro(rs.getString("ven_nome_passageiro"));
                venda.setValor(rs.getFloat("ven_valor"));
                venda.setSituacao(rs.getString("ven_situacao"));

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
                onibus.getIdModelo();

                rota.setIdOnibus(onibus);

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
                funcionario.getIdEndereco();
                funcionario.getIdCargo();

                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cli_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setDtNascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.getIdEndereco();

                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setCodigo(rs.getInt("pag_id"));
                formaPagamento.setFormaPagamento(rs.getString("pag_descricao"));

                venda.setIdRota(rota);
                venda.setIdFuncionario(funcionario);
                venda.setIdCliente(cliente);
                venda.setIdFormaDePagamento(formaPagamento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR DADOS!");
        }
        return venda;
    }

    public Vector<Rota> listarRotas() {
        Vector<Rota> rotas = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from rotas r\n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id\n"
                    + "inner join modelos m on o.oni_fk_mod = m.mod_id");
            ResultSet rs = ps.executeQuery();

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
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR AS ROTAS!");
        }
        return rotas;
    }

    public Vector<Funcionario> listarFuncionarios() {
        Vector<Funcionario> funcionarios = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from funcionarios f\n"
                    + "inner join cargos cr on f.fun_fk_car = cr.car_id\n"
                    + "where cr.car_descricao like '%Vendedor%'");
            ResultSet rs = ps.executeQuery();

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
                funcionario.getIdEndereco();

                Cargo cargo = new Cargo();
                cargo.setCodigo(rs.getInt("car_id"));
                cargo.setDescricao(rs.getString("car_descricao"));
                cargo.setSalario(rs.getFloat("car_salario"));

                funcionario.setIdCargo(cargo);

                funcionarios.add(funcionario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR OS FUNCIONÁRIOS!");
        }
        return funcionarios;
    }

    public Vector<Cliente> listarClientes() {
        Vector<Cliente> clientes = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from clientes");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cli_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setDtNascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.getIdEndereco();

                clientes.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR OS CLIENTES!");
        }
        return clientes;
    }

    public Vector<FormaPagamento> listarFormasPagamento() {
        Vector<FormaPagamento> formasPagamento = new Vector<>();
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM formas_pagamento");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setCodigo(rs.getInt("pag_id"));
                formaPagamento.setFormaPagamento(rs.getString("pag_descricao"));
                formasPagamento.add(formaPagamento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO MOSTRAR AS FORMAS DE PAGAMENTO!");
        }
        return formasPagamento;
    }

    public int pegarNPoltronas(int id) {
        int resultado = 0;
        try {
            PreparedStatement ps = conexao.prepareStatement("select o.oni_poltronas from rotas r\n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id \n"
                    + "where r.rot_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            resultado = rs.getInt("oni_poltronas");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO PEGAR Nº DE POLTRONAS NO BANCO!");
        }
        return resultado;
    }

    public float pegarPreco(int id) {
        int resultado = 0;
        try {
            PreparedStatement ps = conexao.prepareStatement("select r.rot_preco from rotas r\n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id \n"
                    + "where r.rot_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            resultado = rs.getInt("rot_preco");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO PEGAR PREÇO NO BANCO!");
        }
        return resultado;
    }

    public boolean verificarAssentos(int id, int assento) {
        boolean resultado = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("select * from vendas v\n"
                    + "inner join rotas r on v.ven_fk_rot = r.rot_id \n"
                    + "inner join onibus o on r.rot_fk_oni = o.oni_id \n"
                    + "inner join funcionarios f on v.ven_fk_fun = f.fun_id \n"
                    + "inner join clientes c on v.ven_fk_cli = c.cli_id \n"
                    + "inner join formas_pagamento p on v.ven_fk_pag = p.pag_id \n"
                    + "where r.rot_id = ? and v.ven_assento = ?");
            ps.setInt(1, id);
            ps.setInt(2, assento);

            ResultSet rs = ps.executeQuery();

            resultado = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR ASSENTOS E ROTA! ");
        }
        return resultado;
    }
}
