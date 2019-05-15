package dao;

import db.ConnectionFactory;
import modelo.Pessoa;
import modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements DaoInterface<Produto> {
    @Override
    public void insert(Produto produto) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO produto (PRODUTO_NOME, PRODUTO_PRECO, PRODUTO_QUANTIDADE, PRODUTO_DESCRICAO)" + "VALUES(?,?,?,?)";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, produto.getNome());
                pstmt.setFloat(2, produto.getPreco());
                pstmt.setInt(3, produto.getQuantidade());
                pstmt.setString(4, produto.getDescricao());

                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }
    }

    @Override
    public void update(Produto produto, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE produto SET PRODUTO_NOME = ?, PRODUTO_PRECO = ?, PRODUTO_QUANTIDADE = ?, PRODUTO_DESCRICAO = ? WHERE PESSOA_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, produto.getNome());
            pstmt.setFloat(2, produto.getPreco());
            pstmt.setFloat(3, produto.getQuantidade());
            pstmt.setString(4, produto.getDescricao());

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

        String sql = "DELETE FROM produto WHERE PRODUTO_ID = ?";

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
    public Produto search(int id) {

        Produto produto = new Produto();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PRODUTO_ID, PRODUTO_NOME, PRODUTO_PRECO, PRODUTO_QUANTIDADE, PRODUTO_DESCRICAO FROM produto WHERE PRODUTO_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setPreco(rs.getFloat(3));
                produto.setQuantidade(rs.getInt(4));
                produto.setDescricao(rs.getString(5));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    @Override
    public List<Produto> searchAll() {

        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PRODUTO_ID, PRODUTO_NOME, PRODUTO_PRECO, PRODUTO_QUANTIDADE, PRODUTO_DESCRICAO FROM produto ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setPreco(rs.getFloat(3));
                produto.setQuantidade(rs.getInt(4));
                produto.setDescricao(rs.getString(5));

                produtos.add(produto);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
