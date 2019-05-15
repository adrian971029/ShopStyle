package dao;

import db.ConnectionFactory;
import modelo.ItemPedido;
import modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDao implements DaoInterface<ItemPedido> {
    @Override
    public void insert(ItemPedido itemPedido) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO item_pedido (PEDIDO_ID, PRODUTO_ID, ITEMPEDIDO_QUANTIDADE)" + "VALUES(?,?,?)";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, itemPedido.getPedidoId());
                pstmt.setInt(2, itemPedido.getProdutoId());
                pstmt.setInt(3, itemPedido.getQuantidade());

                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }
    }

    @Override
    public void update(ItemPedido itemPedido, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE item_pedido SET PEDIDO_ID = ?, PRUDUTO_ID = ?, ITEMPEDIDO_QUANTIDADE = ? WHERE PESSOA_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, itemPedido.getPedidoId());
            pstmt.setInt(2, itemPedido.getProdutoId());
            pstmt.setInt(3, itemPedido.getQuantidade());

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

        String sql = "DELETE FROM item_pedido WHERE ITEMPEDIDO_ID = ?";

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
    public ItemPedido search(int id) {

        ItemPedido itemPedido = new ItemPedido();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT ITEMPEDIDO_ID, PEDIDO_ID, PRODUTO_ID, ITEMPEDIDO_QUANTIDADE FROM itempedido WHERE ITEMPEDIDO_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                itemPedido.setId(rs.getInt(1));
                itemPedido.setPedidoId(rs.getInt(2));
                itemPedido.setProdutoId(rs.getInt(3));
                itemPedido.setQuantidade(rs.getInt(4));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemPedido;
    }

    @Override
    public List<ItemPedido> searchAll() {

        ArrayList<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT ITEMPEDIDO_ID, PEDIDO_ID, PRODUTO_ID, ITEMPEDIDO_QUANTIDADE FROM itempedido";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setId(rs.getInt(1));
                itemPedido.setPedidoId(rs.getInt(2));
                itemPedido.setProdutoId(rs.getInt(3));
                itemPedido.setQuantidade(rs.getInt(4));

                itemPedidos.add(itemPedido);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemPedidos;
    }
}
