package com.mbtec.staffnoc.domain;

public class Worker {
    private String name;
    private String phonenumber;
    private String profile;

    public Worker(String name, String phonenumber, String profile) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.profile = profile;
    }

    public Worker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
