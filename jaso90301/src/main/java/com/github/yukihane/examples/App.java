package com.github.yukihane.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        String resource = """
                1.ああああああああああああ
                2.いいいいいいいいいいいいい
                3.うううううううううううううううう
                ええええええええ6.jpgええええええ
                おおおおおおおおおおおおおお
                4.あああああああああ
                ああああああああああああああ
                あああああ6.70.ああああ
                """;

        Pattern pattern = Pattern.compile("(?:^|\\n)(\\d+\\..*?)(?=\\n\\d+\\.|\\n$)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(resource);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println();
        }
    }
}
