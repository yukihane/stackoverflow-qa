package com.github.yukihane;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void testApp() {
        String literal_neko = "ネコ";
        String literal_ne_ko = "ネ" + "コ";

        // (1) https://docs.oracle.com/javase/specs/jls/se13/html/jls-3.html#jls-3.10.5
        System.out.println("literal_neko == literal_ne_and_ko: " + (literal_neko == literal_ne_ko)); // true

        // (2) finalなStringの連結: true
        final String final_ne = "ネ";
        final String final_ko = "コ";
        String final_ne_and_final_ko = final_ne + final_ko;

        System.out.println("literal_neko == final_ne_final_ko: " + (literal_neko == final_ne_and_final_ko)); // true

        // (3) 非final(だが実質final)なStringの連結: false
        String ne = "ネ";
        String ko = "コ";
        String ne_and_ko = ne + ko;

        System.out.println("literal_neko == ne_and_ko: " + (literal_neko == ne_and_ko)); // false

        Runnable r = () -> {
            // ne, ko, neko いずれも実質finalなので参照可能
            String neko_runnable = ne + ko;
            System.out.println("literal_neko == neko_runnable: " + (literal_neko == neko_runnable)); // false
            System.out.println("ne_and_ko == neko_runnable: " + (ne_and_ko == neko_runnable)); // false
        };
        r.run();
    }
}
