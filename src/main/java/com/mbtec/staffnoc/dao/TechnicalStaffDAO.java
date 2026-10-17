package com.mbtec.staffnoc.dao;

import com.mbtec.staffnoc.DB.Conexao;
import com.mbtec.staffnoc.domain.Technical_Staff;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicalStaffDAO implements DAO<Technical_Staff> {

    @Override
    public void create(@NotNull Technical_Staff staff) {
        String sql = "INSERT INTO staff (name, phonenumber, profile, usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getPhonenumber());
            stmt.setString(3, staff.getProfile());
            stmt.setString(4, staff.getUsuario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao inserir técnico: " + e.getMessage());
        }
    }

    @Override
    public List<Technical_Staff> list() {
        List<Technical_Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM staff";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Technical_Staff staff = new Technical_Staff();
                staff.setIdtecstaff(rs.getInt("idstaff"));
                staff.setName(rs.getString("name"));
                staff.setPhonenumber(rs.getString("phonenumber"));
                staff.setProfile(rs.getString("profile"));
                staff.setUsuario(rs.getString("usuario"));

                list.add(staff);

            }

        } catch (SQLException e) {
            System.err.println("Error from listing: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Technical_Staff staff) {

        String sql = "UPDATE staff SET name=?, phonenumber=?, profile=?, usuario=? WHERE idstaff=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getPhonenumber());
            stmt.setString(3, staff.getProfile());
            stmt.setString(4, staff.getUsuario());
            stmt.setInt(5, staff.getIdtecstaff());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error when updating the Staff: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM staff WHERE idstaff=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error on deleting the Staff" + e.getMessage());
        }
    }

    @Override
    public List<Technical_Staff> search(String term) {
        return List.of();
    }
}
