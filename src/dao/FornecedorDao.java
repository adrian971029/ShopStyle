package dao;

import db.ConnectionFactory;
import modelo.Cliente;
import modelo.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao implements DaoInterface<Fornecedor> {
    @Override
    public void insert(Fornecedor fornecedor) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO fornecedor (PESSOA_ID, FORNECEDOR_CNPJ, FORNECEDOR_RAZAO)" + "VALUES(?,?,?)";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, fornecedor.getPessoaId());
                pstmt.setString(2, fornecedor.getCnpj());
                pstmt.setString(3, fornecedor.getRazao());


                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }
    }

    @Override
    public void update(Fornecedor fornecedor, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE fornecedor SET PESSOA_ID = ?, FORNECEDOR_CNPJ = ?, FORNECEDOR_RAZAO = ? WHERE PESSOA_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, fornecedor.getPessoaId());
            pstmt.setString(2, fornecedor.getCnpj());
            pstmt.setString(3, fornecedor.getRazao());

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

        String sql = "DELETE FROM fornecedor WHERE FORNECEDOR_ID = ?";

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
    public Fornecedor search(int id) {

        Fornecedor fornecedor = new Fornecedor();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT FORNECEDOR_ID, PESSOA_ID, FORNECEDOR_CNPJ, FORNECEDOR_RAZAO FROM fornecedor WHERE FORNECEDOR_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                fornecedor.setId(rs.getInt(1));
                fornecedor.setPessoaId(rs.getInt(2));
                fornecedor.setCnpj(rs.getString(3));
                fornecedor.setRazao(rs.getString(3));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedor;

    }

    @Override
    public List<Fornecedor> searchAll() {

        ArrayList<Fornecedor> fornecedors = new ArrayList<Fornecedor>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT FORNECEDOR_ID, PESSOA_ID, FORNECEDOR_CNPJ, FORNECEDOR_RAZAO FROM fornecedor";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt(1));
                fornecedor.setPessoaId(rs.getInt(2));
                fornecedor.setCnpj(rs.getString(3));
                fornecedor.setRazao(rs.getString(4));

                fornecedors.add(fornecedor);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedors;
    }
}
