package com.mbtec.staffnoc.domain;


public class Province {

    private Integer idprovince;
    private String province_name;
    private Boolean active;

    public Integer getIdprovince() {
        return idprovince;
    }

    public void setIdprovince(Integer idprovince) {
        this.idprovince = idprovince;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
