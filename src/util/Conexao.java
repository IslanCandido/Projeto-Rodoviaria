package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao = null;

    public static Connection getConexao() {
        if (conexao != null) {
            return conexao;
        } else {
            try {
                String DBUrl = "jdbc:postgresql://localhost:5432/Rodoviaria";
                String usuario = "postgres";
                String senha = "root";
                String driver = "org.postgresql.Driver";

                Class.forName(driver);
                conexao = DriverManager.getConnection(DBUrl, usuario, senha);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conexao;
        }
    }
}
