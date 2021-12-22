package stackoverflow;

import com.google.common.primitives.Bytes;
import org.apache.commons.lang3.ArrayUtils;

public class App {

    public static void main(final String[] args) {

        final byte[] b0 = { 0x00, 0x00, 0x00, 0x00 };
        final byte[] b1 = { 0x00, 0x01, 0x02, 0x03 };
        final byte[] b2 = { 0x01, 0x02, 0x03, 0x04 };


        if ((b0[0] | b0[1] | b0[2] | b0[3]) != 0) {
            System.out.println("b0 match");
        }
        if ((b1[0] | b1[1] | b1[2] | b1[3]) != 0) {
            System.out.println("b1 match");
        }
        if ((b2[0] | b2[1] | b2[2] | b2[3]) != 0) {
            System.out.println("b2 match");
        }

        if (!Bytes.contains(b2, (byte) 0)) {
            System.out.println("guava");
        }

        if (!ArrayUtils.contains(b2, (byte) 0)) {
            System.out.println("commons lang");
        }

        if (!containsZero(b2)) {
            System.out.println("my impl");
        }
    }

    public static boolean containsZero(final byte[] array) {
        for (final byte b : array) {
            if (b == 0x00) {
                return true;
        }
    }
    return false;
}
}
