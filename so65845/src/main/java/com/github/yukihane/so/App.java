package com.github.yukihane.so;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;

public class App {

    public static void main(String[] args) {

        Kusa kusa = new Kusa();
        kusa.setKusa("草");
        Kusa2 kusa2 = new Kusa2();
        kusa2.setKusa2("草2");
        kusa.setKusa2(kusa2);
        Kusa3 kusa3 = new Kusa3();
        kusa3.setKusa3("草３");
        kusa.setKusa3(kusa3);
        System.out.println("**************************************");
        JAXB.marshal(kusa, System.out);
        System.out.println("**************************************");
    }
}

class Kusa {

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

class Kusa2 {
    private String kusa2;


    public String getKusa2() {
        return kusa2;
    }
    @XmlElement(nillable = true)
    public void setKusa2(String kusa2) {
        this.kusa2 = kusa2;
    }

}

class Kusa3 {
    private String kusa3;

    public String getKusa3() {
        return kusa3;
    }
    @XmlElement(nillable = true)
    public void setKusa3(String kusa3) {
        this.kusa3 = kusa3;
    }
}
