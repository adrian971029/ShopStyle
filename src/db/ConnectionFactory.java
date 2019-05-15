package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    public java.sql.Connection getConnection() {

        String URL = "jdbc:mysql://localhost:3306/shopstyle";
        String usuario = "root";
        String senha = "masterkey";

        Properties properties = new Properties();
        properties.setProperty("user", usuario);
        properties.setProperty("password", senha);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        Connection conexao;

        try {
            Class.forName("com.mysql.jdbc.Driver");
           conexao = DriverManager.getConnection(URL, properties);
        }catch(Exception e) {
            conexao = null;
        }

        return conexao;
    }

}
