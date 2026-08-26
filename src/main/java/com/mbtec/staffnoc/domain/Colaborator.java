package com.mbtec.staffnoc.domain;

public class  Colaborator extends Worker{
    private int idcolab;

    public Colaborator(String name, String phonenumber, String profile, int idcolab) {
        super(name, phonenumber, profile);
        this.idcolab = idcolab;
    }

    public Colaborator() {
    }

    public Colaborator(int idcolab) {
        this.idcolab = idcolab;
    }

    public int getIdcolab() {
        return idcolab;
    }

    public void setIdcolab(int idcolab) {
        this.idcolab = idcolab;
    }

    @Override
    public String toString() {
        return "Colaborator{" +
                "idcolab=" + idcolab + '\'' +
                ", "+ super.toString() +
                '}';
    }
}
