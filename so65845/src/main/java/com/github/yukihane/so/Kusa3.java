package com.github.yukihane.so;

import javax.xml.bind.annotation.XmlElement;

public class Kusa3 {
    private String kusa3;

    public String getKusa3() {
        return kusa3;
    }
    @XmlElement(nillable = true)
    public void setKusa3(String kusa3) {
        this.kusa3 = kusa3;
    }
}
