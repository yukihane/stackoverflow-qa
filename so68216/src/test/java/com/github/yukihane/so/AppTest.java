package com.github.yukihane.so;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test(@Mocked Hoge hoge) {

        new Expectations() {
            {
                hoge.get();
                result = Collections.emptyList();
            }
        };

        assertThat(hoge.get().isEmpty()).isEqualTo(true);
    }

    public static class Hoge {
        public List<String> get() {
            return Arrays.asList("aa");
        }
    }
}
