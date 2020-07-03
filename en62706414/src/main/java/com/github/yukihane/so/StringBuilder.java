package com.github.yukihane.so;

public class StringBuilder {
    public static void main(final String[] args) {
        final String nimi = Syotto.kysy("Give Lastname Firstname");
        final java.lang.StringBuilder sb = new java.lang.StringBuilder(nimi);
        removeFirstWord(sb);

        System.out.println("Your last name is " + sb);
        final String lastname = giveFirstWord(nimi);
        System.out.println("Your last name is " + lastname);
    }

    public static String removeFirstWord(final java.lang.StringBuilder sb) {
        final String bs = sb.toString();
        final int remove = bs.indexOf(" ");
        final String second = bs.substring(0, remove);
        return second;

    }

    public static String giveFirstWord(final String fname) {
        final int s1 = fname.indexOf(' ');
        final String d2 = fname.substring(s1, 14);
        return d2;
    }

}
