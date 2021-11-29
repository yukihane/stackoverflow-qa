import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SubClassTest {

    @Test
    void test() {
        int[] num = { 1,2,3,4,5,6 };
        SuperClass myArray = new SubClass(num);
        String result = myArray.execute();
        assertThat(result).isEqualTo("11");
    }

}
