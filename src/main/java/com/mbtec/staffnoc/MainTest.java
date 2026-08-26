package com.mbtec.staffnoc;

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
            System.out.println("*********************TEAM PEMBA*********************");
            System.out.println("Site: " + list.getSite_code() + "\n " +
                    " Bairro: " + list.getStreet() + "\n " +
                    " Tecnico: " + list.getTechnical_staff().getName() + "\n "
                    +
                    " Tel: " + list.getTechnical_staff().getPhonenumber() + "\n "
                    + " Colaborador: " + list.getCollab().getName() + "\n " +
                    " Tel: " + list.getCollab().getPhonenumber());
        }

        Activity activity = new Activity();
        activity.setBts(getBts().getFirst());
        activity.setActivity("Manutencao de Link Cab0013 a Cab107");
        activity.setCurrenty_month("Agosto");
        activity.setDone(false);
        activity.setDate_done("");
        System.out.println("Atividade: " + activity);
    }

    private static List<Bts> getBts() {

        Technical_Staff tecnico = new Technical_Staff();
        tecnico.setName("Zulo Mitumba");
        tecnico.setPhonenumber("876660002");
        tecnico.setProfile("Staff");
        tecnico.setUsuario("Mitumba");

        Colaborator colab = new Colaborator();
        colab.setName("Saide Mitumba");
        colab.setPhonenumber("866661333");
        colab.setProfile("Colaborador");

        Colaborator colab1 = new Colaborator();
        colab1.setName("Yassiro Likoko");
        colab1.setPhonenumber("86888888");
        colab1.setProfile("Colaborador");


        Bts bts1 = new Bts(1, "Cab0013", "Estadio Municipal", "Tem",
                "14555277838", tecnico, colab);

        Bts bts2 = new Bts(2, "Cab0012", "IICP", "Tem",
                "54555277830", tecnico, colab1);

        List<Bts> bts = new ArrayList<>();
        bts.add(bts1);
        bts.add(bts2);
        return bts;
    }
}
