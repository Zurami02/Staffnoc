package com.mbtec.staffnoc.dao;

import com.mbtec.staffnoc.DB.Conexao;
import com.mbtec.staffnoc.domain.Colaborator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboratorDAO implements DAO<Colaborator> {
    @Override
    public void create(Colaborator colab) {
        String sql = "INSERT INTO collaborator (name_colab, phonenumber_colab, profile_colab) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, colab.getName());
            stmt.setString(2, colab.getPhonenumber());
            stmt.setString(3, colab.getProfile());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error to create he Collaborator: " + e.getMessage());
        }
    }

    @Override
    public List<Colaborator> list() {
        List<Colaborator> list = new ArrayList<>();
        String sql = "SELECT * FROM collaborator";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Colaborator collab = new Colaborator();
                collab.setIdcolab(rs.getInt("idcollab"));
                collab.setName(rs.getString("name_colab"));
                collab.setPhonenumber(rs.getString("phonenumber_colab"));
                collab.setProfile(rs.getString("profile_colab"));

                list.add(collab);
                System.out.println(collab);

            }

        } catch (SQLException e) {
            System.err.println("Error from listing: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Colaborator collab) {
        String sql = "UPDATE collaborator SET name_colab=?, phonenumber_colab=?, profile_colab=? WHERE idcollab=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, collab.getName());
            stmt.setString(2, collab.getPhonenumber());
            stmt.setString(3, collab.getProfile());
            stmt.setInt(4, collab.getIdcolab());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error when updating the Collaborator: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM collaborator WHERE idcollab=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error on deleting the Collaborator" + e.getMessage());
        }
    }

    @Override
    public List<Colaborator> search(String term) {
        return List.of();
    }
}
