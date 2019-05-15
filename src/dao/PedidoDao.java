package dao;

import db.ConnectionFactory;
import modelo.Pedido;
import modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao implements DaoInterface<Pedido> {
    @Override
    public void insert(Pedido pedido) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO pedido (PESSOA_ID, PEDIDO_VALOR, PEDIDO_DESCONTO, PEDIDO_VALORLIQUIDO)" + "VALUES(?,?,?,?)";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, pedido.getPessoaId());
                pstmt.setFloat(2, pedido.getValor());
                pstmt.setFloat(3, pedido.getDesconto());
                pstmt.setFloat(4, pedido.getValorliquido());

                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }
    }

    @Override
    public void update(Pedido pedido, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE PEDIDO SET PESSOA_ID = ?, PEDIDO_VALOR = ?, PEDIDO_DESCONTO = ?, PEDIDO_VALORLIQUIDO = ? WHERE PESSOA_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, pedido.getPessoaId());
            pstmt.setFloat(2, pedido.getValor());
            pstmt.setFloat(3, pedido.getDesconto());
            pstmt.setFloat(4, pedido.getValorliquido());

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

        String sql = "DELETE FROM pedido WHERE PEDIDO_ID = ?";

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
    public Pedido search(int id) {

        Pedido pedido = new Pedido();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PEDIDO_ID, PESSOA_ID, PEDIDO_VALOR, PEDIDO_DESCONTO, PEDIDO_VALORLIQUIDO FROM pedido WHERE PEDIDO_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pedido.setId(rs.getInt(1));
                pedido.setPessoaId(rs.getInt(2));
                pedido.setValor(rs.getFloat(3));
                pedido.setDesconto(rs.getFloat(4));
                pedido.setValorliquido(rs.getFloat(5));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedido;
    }

    @Override
    public List<Pedido> searchAll() {

        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PEDIDO_ID, PESSOA_ID, PEDIDO_VALOR, PEDIDO_DESCONTO, PEDIDO_VALORLIQUIDO FROM pedido";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt(1));
                pedido.setPessoaId(rs.getInt(2));
                pedido.setValor(rs.getFloat(3));
                pedido.setDesconto(rs.getFloat(4));
                pedido.setValorliquido(rs.getFloat(5));

                pedidos.add(pedido);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}
