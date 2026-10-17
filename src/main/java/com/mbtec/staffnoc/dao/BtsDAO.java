package com.mbtec.staffnoc.dao;

import com.mbtec.staffnoc.DB.Conexao;
import com.mbtec.staffnoc.domain.Bts;
import com.mbtec.staffnoc.domain.Colaborator;
import com.mbtec.staffnoc.domain.Technical_Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BtsDAO implements DAO<Bts> {
    @Override
    public void create(Bts bts) {
        String sql = "INSERT INTO bts (site_code, street, generator, edm_meter, solar, idstaff, idcollab) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bts.getSite_code());
            stmt.setString(2, bts.getStreet());
            stmt.setString(3, bts.getGen());
            stmt.setString(4, bts.getMeter_edm());
            stmt.setBoolean(5, bts.isSolar());
            stmt.setInt(6, bts.getTechnical_staff().getIdtecstaff());
            stmt.setInt(7, bts.getCollab().getIdcolab());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error creating the BTS: " + e.getMessage());
        }
    }

    @Override
    public List<Bts> list() {
        List<Bts> list = new ArrayList<>();
        String sql = "SELECT b.idbts, b.site_code, b.street, b.generator, b.edm_meter, b.solar, " +
                "s.idstaff, s.name AS tec_name, s.phonenumber AS tec_phone, s.profile AS tec_profile, s.usuario, " +
                "c.idcollab, c.name_colab, c.phonenumber_colab, c.profile_colab " +
                "FROM bts b " +
                "LEFT JOIN staff s ON b.idstaff = s.idstaff " +
                "LEFT JOIN collaborator c ON b.idcollab = c.idcollab";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Technical_Staff staff = new Technical_Staff();
                staff.setIdtecstaff(rs.getInt("idstaff"));
                staff.setName(rs.getString("tec_name"));
                staff.setPhonenumber(rs.getString("tec_phone"));
                staff.setProfile(rs.getString("tec_profile"));
                staff.setUsuario(rs.getString("usuario"));

                Colaborator collab = new Colaborator();
                collab.setIdcolab(rs.getInt("idcollab"));
                collab.setName(rs.getString("name_colab"));
                collab.setPhonenumber(rs.getString("phonenumber_colab"));
                collab.setProfile(rs.getString("profile_colab"));

                Bts bts = new Bts();
                bts.setIdbts(rs.getInt("idbts"));
                bts.setSite_code(rs.getString("site_code"));
                bts.setStreet(rs.getString("street"));
                bts.setGen(rs.getString("generator"));
                bts.setMeter_edm(rs.getString("edm_meter"));
                bts.setSolar(rs.getBoolean("solar"));
                bts.setTechnical_staff(staff);
                bts.setCollab(collab);
                System.out.println(bts);
                list.add(bts);
            }

        } catch (SQLException e) {
            System.err.println("Error from listing: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Bts bts) {
        String sql = "UPDATE bts SET site_code=?, street=?, generator=?, edm_meter=?, solar=?, idstaff=?, idcollab=? WHERE idbts=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bts.getSite_code());
            stmt.setString(2, bts.getStreet());
            stmt.setString(3, bts.getGen());
            stmt.setString(4, bts.getMeter_edm());
            stmt.setBoolean(5, bts.isSolar());
            stmt.setInt(6, bts.getTechnical_staff().getIdtecstaff());
            stmt.setInt(7, bts.getCollab().getIdcolab());
            stmt.setInt(8, bts.getIdbts());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error when updating the BTS: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM bts WHERE idbts=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error on deleting the BTS" + e.getMessage());
        }
    }

    @Override
    public List<Bts> search(String term) {
        return List.of();
    }
}
