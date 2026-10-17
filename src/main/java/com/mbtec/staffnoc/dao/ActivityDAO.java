package com.mbtec.staffnoc.dao;

import com.mbtec.staffnoc.DB.Conexao;
import com.mbtec.staffnoc.domain.Activity;
import com.mbtec.staffnoc.domain.Bts;
import com.mbtec.staffnoc.domain.Colaborator;
import com.mbtec.staffnoc.domain.Technical_Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO implements DAO<Activity> {
    @Override
    public void create(Activity activity) {
        String sql = "INSERT INTO activity (activity, done, date_done, currenty_month, idbts) VALUE (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, activity.getActivity());
            stmt.setBoolean(2, activity.isDone());
            stmt.setString(3, activity.getDate_done());
            stmt.setString(4, activity.getCurrenty_month());
            stmt.setInt(5, activity.getBts().getIdbts());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error creating the Activity: " + e.getMessage());
        }
    }

    @Override
    public List<Activity> list() {
        List<Activity> list = new ArrayList<>();
        String sql = "SELECT act.idactivity, act.activity, act.done, act.date_done, act.currenty_month, " +
                "b.idbts, b.site_code, b.street, b.generator, b.edm_meter, b.solar, " +
                "s.idstaff, s.name AS tec_name, s.phonenumber AS tec_phone, s.profile AS tec_profile, s.usuario, " +
                "c.idcollab, c.name_colab, c.phonenumber_colab, c.profile_colab " +
                "FROM activity act " +
                "LEFT JOIN bts b ON act.idbts = b.idbts " +
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

                Activity act = new Activity();
                act.setIdactivity(rs.getInt("idactivity"));
                act.setActivity(rs.getString("activity"));
                act.setDone(rs.getBoolean("done"));
                act.setDate_done(rs.getString("date_done"));
                act.setCurrenty_month(rs.getString("currenty_month"));
                act.setBts(bts);
                list.add(act);
            }

        } catch (SQLException e) {
            System.err.println("Error from listing: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Activity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Activity> search(String term) {
        return List.of();
    }
}
