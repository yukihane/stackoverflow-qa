package com.github.yukihane.so;

import javax.xml.bind.annotation.XmlElement;

public class Kusa {

    private String kusa;
    private Kusa2 kusa2;
    private Kusa3 kusa3;
    @XmlElement(nillable = true)
    public String getKusa() {
        return kusa;
    }

    public void setKusa(String kusa) {
        this.kusa = kusa;
    }

    public Kusa2 getKusa2() {
        return kusa2;
    }

    public void setKusa2(Kusa2 kusa2) {
        this.kusa2 = kusa2;
    }
    public Kusa3 getKusa3() {
        return kusa3;
    }

    public void setKusa3(Kusa3 kusa3) {
        this.kusa3 = kusa3;
    }

}
