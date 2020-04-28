package com.github.yukihane.so;

import javax.xml.bind.annotation.XmlElement;

public class Kusa2 {
    private String kusa2;


    public String getKusa2() {
        return kusa2;
    }
    @XmlElement(nillable = true)
    public void setKusa2(String kusa2) {
        this.kusa2 = kusa2;
    }

}
