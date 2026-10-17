package com.mbtec.staffnoc.domain;

public class Bts {
    private int idbts;
    private String site_code;//Cab0013
    private String street;
    private String gen;
    private String meter_edm;
    private boolean solar;
    private Technical_Staff technical_staff;
    private Colaborator collab;

    public Bts(int idbts, String site_code, String street,
               String gen, String meter_edm, boolean solar, Technical_Staff technical_staff, Colaborator collab) {
        this.idbts = idbts;
        this.site_code = site_code;
        this.street = street;
        this.gen = gen;
        this.meter_edm = meter_edm;
        this.solar = solar;
        this.technical_staff = technical_staff;
        this.collab = collab;
    }

    public Bts() {
    }

    public boolean isSolar() {
        return solar;
    }

    public void setSolar(boolean solar) {
        this.solar = solar;
    }

    public int getIdbts() {
        return idbts;
    }

    public void setIdbts(int idbts) {
        this.idbts = idbts;
    }

    public String getSite_code() {
        return site_code;
    }

    public void setSite_code(String site_code) {
        this.site_code = site_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getMeter_edm() {
        return meter_edm;
    }

    public void setMeter_edm(String meter_edm) {
        this.meter_edm = meter_edm;
    }

    public Technical_Staff getTechnical_staff() {
        return technical_staff;
    }

    public void setTechnical_staff(Technical_Staff technical_staff) {
        this.technical_staff = technical_staff;
    }

    public Colaborator getCollab() {
        return collab;
    }

    public void setCollab(Colaborator collab) {
        this.collab = collab;
    }

    @Override
    public String toString() {
        return "Bts{" +
                "idbts=" + idbts +
                ", site_code='" + site_code + '\'' +
                ", street='" + street + '\'' +
                ", gen='" + gen + '\'' +
                ", meter_edm='" + meter_edm + '\'' +
                ", technical_staff=" + technical_staff +
                ", collab=" + collab +
                '}';
    }
}
