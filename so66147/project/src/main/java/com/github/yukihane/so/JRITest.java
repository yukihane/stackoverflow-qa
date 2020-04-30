package com.github.yukihane.so;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class JRITest {

    public static void main(final String[] args) {
        final Rengine engine = new Rengine(new String[] { "--no-save" }, false, null);
        engine.assign("a", new int[] { 36 });
        final REXP result = engine.eval("sqrt(a)");
        System.out.println(result.asDouble());
        engine.end();
    }
}
