package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    public static void main(String[] args)
            throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/shopstyle";
        String usuario = "root";
        String senha = "masterkey";

        Properties properties = new Properties();
        properties.setProperty("user", usuario);
        properties.setProperty("password", senha);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");


        Connection conexao = DriverManager.getConnection(URL, properties);

        if (conexao != null) {
            System.out.println("conectado!");
        } else {
            System.out.println("erro!");
        }


        conexao.close();
    }

}
