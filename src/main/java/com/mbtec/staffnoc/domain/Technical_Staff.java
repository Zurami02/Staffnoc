package com.mbtec.staffnoc.domain;

public class Technical_Staff extends Worker {
    private int idtecstaff;
    private String usuario;

    public Technical_Staff(String name, String phonenumber, String profile, int idtecstaff, String usuario) {
        super(name, phonenumber, profile);
        this.idtecstaff = idtecstaff;
        this.usuario = usuario;
    }

    public Technical_Staff(int idtecstaff, String usuario) {
        this.idtecstaff = idtecstaff;
        this.usuario = usuario;
    }

    public Technical_Staff() {
    }

    public int getIdtecstaff() {
        return idtecstaff;
    }

    public void setIdtecstaff(int idtecstaff) {
        this.idtecstaff = idtecstaff;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Technical_Staff{" +
                "idtecstaff=" + idtecstaff +
                ", usuario='" + usuario + '\'' +
                ", " + super.toString() +
                '}';
    }
}
