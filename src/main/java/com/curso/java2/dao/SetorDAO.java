package com.curso.java2.dao;

import com.curso.java2.model.Setor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDAO {
    private Connection con = null;

    public void adicionarSetor(Setor setor){
        try {
            con = Dao.getConnection();

            String sql = "INSERT INTO setor(nome) VALUES(?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, setor.getNome());

            stmt.execute();
            System.out.println("\nSetor Adicionado no Banco de Dados\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(con);
        }
    }

    public void alterarSetor(Setor setor){
        try {
            con = Dao.getConnection();

            String sql = "UPDATE setor SET nome = ? WHERE id_setor = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, setor.getNome());
            stmt.setLong(2, setor.getIdSetor());

            stmt.execute();
            System.out.println("\nSetor Alterado no Banco de Dados\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(con);
        }
    }

    public void deletarSetor(Long setorId){
        try {
            con = Dao.getConnection();

            String sql = "DELETE FROM setor WHERE id_setor = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setLong(1, setorId);

            stmt.execute();
            System.out.println("\nSetor Removido no Banco de Dados\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(con);
        }
    }

    public List<Setor> listarSetor(){
        List<Setor> setores = new ArrayList<Setor>();

        String sql = "SELECT id_setor, nome FROM setor";

        try {
            con = Dao.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Setor setor = new Setor();
                setor.setIdSetor(rs.getLong("id_setor"));
                setor.setNome(rs.getString("nome"));

                setores.add(setor);
            }

            rs.close();

            return setores;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return setores;
        }


    }

    public Setor buscarSetorPeloId(Long setorId){
        Setor setor = new Setor();

        try {
            con = Dao.getConnection();

            String sql = "SELECT id_setor, nome FROM setor WHERE id_setor = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setLong(1, setorId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                setor.setIdSetor(rs.getLong("id_setor"));
                setor.setNome(rs.getString("nome"));
            }

            rs.close();

            return setor;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(con);
            return setor;
        }
    }
}
