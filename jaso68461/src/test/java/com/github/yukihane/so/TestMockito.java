package com.github.yukihane.so;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TestMockito {

    @Test
    public void testMockito() {
        final TargetSubClass mock = mock(TargetSubClass.class);
        doNothing().doThrow(new NullPointerException()).when(mock).someMethod(any());

        mock.someMethod(new String[] { "test" });
        mock.someMethod(new String[] { "test" });
    }
}
