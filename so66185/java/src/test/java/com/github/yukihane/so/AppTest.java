package com.github.yukihane.so;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testAvailable() throws ClassNotFoundException {
        assertThat(Class.forName("com.github.yukihane.so.App")).isEqualTo(App.class);
    }

    @Test
    void testUnavailable() {
        assertThatThrownBy(() -> Class.forName("com.github.yukihane.so.Unavailable"))
            .isInstanceOf(ClassNotFoundException.class);
    }

}
