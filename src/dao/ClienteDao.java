package dao;

import db.ConnectionFactory;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements DaoInterface<Cliente>{


    @Override
    public void insert(Cliente cliente) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO cliente (PESSOA_ID, CLIENTE_CPF)" + "VALUES(?,?)";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, cliente.getPessoaId());
                pstmt.setString(2, cliente.getCpf());

                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }
    }

    @Override
    public void update(Cliente cliente, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE cliente SET PESSOA_ID = ?, CLIENTE_CPF = ? WHERE CLIENTE_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, cliente.getPessoaId());
            pstmt.setString(2, cliente.getCpf());

            pstmt.execute();

            pstmt.close();

            conn.close();

        }catch(Exception e) {
            System.out.println("erro :" + e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "DELETE FROM cliente WHERE CLIENTE_ID = ?";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.execute();

            pstmt.close();

            conn.close();

        }catch(Exception e) {
            System.out.println("erro :" + e.getMessage());

        }

    }

    @Override
    public Cliente search(int id) {

        Cliente cliente = new Cliente();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT CLIENTE_ID, PESSOA_ID, CLIENTE_CPF FROM cliente WHERE CLIENTE_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setPessoaId(rs.getInt(2));
                cliente.setCpf(rs.getString(3));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;

    }

    @Override
    public List<Cliente> searchAll() {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT SELECT CLIENTE_ID, PESSOA_ID, CLIENTE_CPF FROM cliente";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setPessoaId(rs.getInt(2));
                cliente.setCpf(rs.getString(3));


                clientes.add(cliente);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
