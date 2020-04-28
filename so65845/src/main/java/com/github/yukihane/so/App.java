package com.github.yukihane.so;

import javax.xml.bind.JAXB;

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
