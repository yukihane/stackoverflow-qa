package com.github.yukihane.so;

import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class App {

    public static void main(final String[] args) throws DecoderException {

        final char[] bytes = Hex.encodeHex("ぁ".getBytes(Charset.forName("Shift_JIS")));
        System.out.println(bytes); // 829f

        final byte[] str = Hex.decodeHex("82F1");
        System.out.println(new String(str, Charset.forName("Shift_JIS")));
    }
}
