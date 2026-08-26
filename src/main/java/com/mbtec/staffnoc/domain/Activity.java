package com.mbtec.staffnoc.domain;

public class Activity {
    private int idactivity;
    private String activity;
    private boolean done;
    private String date_done;
    private String currenty_month;
    private Bts bts;

    public Activity(int idactivity, String activity, boolean done,
                    String date_done, String currenty_month, Bts bts) {
        this.idactivity = idactivity;
        this.activity = activity;
        this.done = done;
        this.date_done = date_done;
        this.currenty_month = currenty_month;
        this.bts = bts;
    }

    public Activity() {
    }

    public int getIdactivity() {
        return idactivity;
    }

    public void setIdactivity(int idactivity) {
        this.idactivity = idactivity;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDate_done() {
        return date_done;
    }

    public void setDate_done(String date_done) {
        this.date_done = date_done;
    }

    public String getCurrenty_month() {
        return currenty_month;
    }

    public void setCurrenty_month(String currenty_month) {
        this.currenty_month = currenty_month;
    }

    public Bts getBts() {
        return bts;
    }

    public void setBts(Bts bts) {
        this.bts = bts;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "idactivity=" + idactivity +
                ", activity='" + activity + '\'' +
                ", done=" + done +
                ", date_done='" + date_done + '\'' +
                ", currenty_month='" + currenty_month + '\'' +
                ", bts=" + bts +
                '}';
    }
}
