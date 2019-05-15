package dao;

import db.ConnectionFactory;
import modelo.Pessoa;
import modelo.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDao implements DaoInterface<Venda> {
    @Override
    public void insert(Venda venda) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO venda (VENDA_DATA, VENDA_VALORLIQUIDO)" + "VALUES(?,?)";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, venda.getData());
                pstmt.setFloat(2, venda.getValorliquido());

                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }
    }

    @Override
    public void update(Venda venda, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE venda  SET PEDIDO_ID = ?, VENDA_DATA = ?, VENDA_VALORLIQUIDO = ? WHERE PESSOA_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, venda.getPedidoId());
            pstmt.setString(2, venda.getData());
            pstmt.setFloat(3, venda.getValorliquido());

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

        String sql = "DELETE FROM venda WHERE VENDA_ID = ?";

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
    public Venda search(int id) {

        Venda venda = new Venda();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT VENDA_ID, PEDIDO_ID, VENDA_DATA, VENDA_VALORLIQUIDO FROM venda WHERE VENDA_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                venda.setId(rs.getInt(1));
                venda.setPedidoId(rs.getInt(2));
                venda.setData(rs.getString(3));
                venda.setValorliquido(rs.getFloat(4));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venda;

    }

    @Override
    public List<Venda> searchAll() {

        ArrayList<Venda> vendas = new ArrayList<Venda>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT VENDA_ID, PEDIDO_ID, VENDA_DATA, VENDA_VALORLIQUIDO FROM venda";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt(1));
                venda.setPedidoId(rs.getInt(2));
                venda.setData(rs.getString(3));
                venda.setValorliquido(rs.getFloat(4));

                vendas.add(venda);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }
}
