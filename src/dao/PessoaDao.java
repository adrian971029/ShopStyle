package dao;

import db.ConnectionFactory;
import modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao implements DaoInterface<Pessoa> {
    @Override
    public void insert(Pessoa pessoa) {

        Connection conn = new ConnectionFactory().getConnection();
        if( conn != null) {
            String sql = "INSERT INTO pessoa (PESSOA_NOME, PESSOA_ENDERECO, PESSOA_CEP, PESSOA_EMAIL, PESSOA_SENHA)" + "VALUES(?,?,?,?,md5(?))";

            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, pessoa.getNome());
                pstmt.setString(2, pessoa.getEndereco());
                pstmt.setString(3, pessoa.getCep());
                pstmt.setString(4, pessoa.getEmail());
                pstmt.setString(5, pessoa.getSenha());

                pstmt.execute();

                pstmt.close();

                conn.close();

            }catch(Exception e) {
                System.out.println("erro :" + e.getMessage());
            }
        }

    }

    @Override
    public void update(Pessoa pessoa, int id) {

        Connection conn = new ConnectionFactory().getConnection();

        String sql = "UPDATE pessoa SET PESSOA_NOME = ?, PESSOA_ENDERECO = ?, PESSOA_CEP = ?, PESSOA_EMAIL, PESSOA_SENHA = ? WHERE PESSOA_ID =" + id;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getEndereco());
            pstmt.setString(3, pessoa.getCep());
            pstmt.setString(4, pessoa.getEmail());
            pstmt.setString(5, pessoa.getSenha());

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

        String sql = "DELETE FROM pessoa WHERE PESSOA_ID = ?";

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
    public Pessoa search(int id) {
        Pessoa pessoa = new Pessoa();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PESSOA_ID, PESSOA_NOME, PESSOA_ENDERECO, PESSOA_CEP, PESSOA_EMAIL, PESSOA_SENHA FROM pessoa WHERE PESSOA_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pessoa.setId(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setEndereco(rs.getString(3));
                pessoa.setCep(rs.getString(4));
                pessoa.setEmail(rs.getString(5));
                pessoa.setSenha(rs.getString(6));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;
    }

    @Override
    public List<Pessoa> searchAll() {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PESSOA_ID, PESSOA_NOME, PESSOA_ENDERECO, PESSOA_CEP, PESSOA_EMAIL, PESSOA_SENHA FROM pessoa";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setEndereco(rs.getString(3));
                pessoa.setCep(rs.getString(4));
                pessoa.setEmail(rs.getString(5));
                pessoa.setSenha(rs.getString(6));

                pessoas.add(pessoa);
            }
            rs.close();

            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public Pessoa searchByEmail(String email) {
        Pessoa pessoa = new Pessoa();
        Connection conn = new ConnectionFactory().getConnection();
        try {

            String sql = "SELECT PESSOA_ID, PESSOA_NOME, PESSOA_ENDERECO, PESSOA_CEP, PESSOA_EMAIL, PESSOA_SENHA FROM pessoa WHERE PESSOA_EMAIL = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int index = 1;
            pstmt.setString(index, email);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pessoa.setId(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setEndereco(rs.getString(3));
                pessoa.setCep(rs.getString(4));
                pessoa.setEmail(rs.getString(5));
                pessoa.setSenha(rs.getString(6));
            }

            rs.close();

            pstmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;
    }

}
