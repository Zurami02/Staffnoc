package com.mbtec.staffnoc;

import com.mbtec.staffnoc.dao.ActivityDAO;
import com.mbtec.staffnoc.dao.BtsDAO;
import com.mbtec.staffnoc.dao.ColaboratorDAO;
import com.mbtec.staffnoc.dao.TechnicalStaffDAO;
import com.mbtec.staffnoc.domain.Activity;
import com.mbtec.staffnoc.domain.Bts;
import com.mbtec.staffnoc.domain.Colaborator;
import com.mbtec.staffnoc.domain.Technical_Staff;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        List<Bts> bts = getBts();
        for (Bts list : bts) {
//            System.out.println("*********************TEAM PEMBA*********************");
//            System.out.println("Site: " + list.getSite_code() + "\n " +
//                    " Bairro: " + list.getStreet() + "\n " +
//                    " Tecnico: " + list.getTechnical_staff().getName() + "\n "
//                    +
//                    " Tel: " + list.getTechnical_staff().getPhonenumber() + "\n "
//                    + " Colaborador: " + list.getCollab().getName() + "\n " +
//                    " Tel: " + list.getCollab().getPhonenumber());
        }

        //System.out.println("Atividade: " + activity);
    }

    private static List<Bts> getBts() {

        Technical_Staff tecnico = new Technical_Staff();
        tecnico.setName("Jone Zacarias");
        tecnico.setPhonenumber("887665555");
        tecnico.setProfile("Staff");
        tecnico.setUsuario("jonaz");

        Technical_Staff tecnico1 = new Technical_Staff();
        tecnico1.setName("Jose Emilio");
        tecnico1.setPhonenumber("876666866");
        tecnico1.setProfile("Staff");
        tecnico1.setUsuario("shomo");

        TechnicalStaffDAO staffdao = new TechnicalStaffDAO();


        Colaborator colab = new Colaborator();
        colab.setName("Saide Mitumba");
        colab.setPhonenumber("866661333");
        colab.setProfile("Colaborador");

        Colaborator colab1 = new Colaborator();
        colab1.setName("Yassiro Likoko");
        colab1.setPhonenumber("86888888");
        colab1.setProfile("Colaborador");

        ColaboratorDAO collaDAO = new ColaboratorDAO();
//        collaDAO.create(colab);
//        collaDAO.create(colab1);

        //collaDAO.list();
        BtsDAO btsDAO = new BtsDAO();
        //btsDAO.list();

        Bts bts1 = new Bts(1, "Cab0013", "Estadio Municipal", "Tem",
                "14555277838", false, tecnico, colab);

        Bts bts2 = new Bts(2, "Cab0012", "IICP", "Tem",
                "54555277830", true, tecnico, colab1);
//        BtsDAO btsDAO = new BtsDAO();
//        btsDAO.create(bts1);
//        btsDAO.create(bts2);
        List<Bts> bts = new ArrayList<>();
        bts.add(bts1);
        bts.add(bts2);

        Activity activity = new Activity();
        activity.setBts(bts1);
        activity.setActivity("Manutencao de Link Cab0013 a Cab107");
        activity.setCurrenty_month("Agosto");
        activity.setDone(false);
        activity.setDate_done("");

        ActivityDAO actDAO = new ActivityDAO();
        //actDAO.create(activity);

        actDAO.list();

        return bts;
    }
}
