package com.mbtec.staffnoc.domain;


public class Team {

    private Integer idteam;
    private String name_team;

    Province province;

    public Integer getIdteam() {
        return idteam;
    }

    public void setIdteam(Integer idteam) {
        this.idteam = idteam;
    }

    public String getName_team() {
        return name_team;
    }

    public void setName_team(String name_team) {
        this.name_team = name_team;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
