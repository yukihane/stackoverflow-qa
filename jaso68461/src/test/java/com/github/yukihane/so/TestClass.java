package com.github.yukihane.so;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class TestClass {

    @Test
    public void test01(@Mocked final TargetSubClass mock) {

        //Arrange
        new Expectations() {
            {
                mock.someMethod((String[]) any);
                result = new Object[] { null, new NullPointerException() }; //２回目でException発生
            }
        };

        //Act
        // 1回の呼び出しならOK
        mock.someMethod(new String[] { "test" });

        //Assert
        /* 本来はここでExceptionが発生することを確認・略  */

    }

    @Test
    public void test01_2(@Mocked final TargetSubClass mock) {

        //Arrange
        new Expectations() {
            {
                mock.someMethod((String[]) any);
                result = new Object[] { null, new NullPointerException() }; //２回目でException発生
            }
        };

        //Act
        // 2回の呼び出しで例外
        mock.someMethod(new String[] { "test" });
        mock.someMethod(new String[] { "test" });

        //Assert
        /* 本来はここでExceptionが発生することを確認・略  */

    }
}