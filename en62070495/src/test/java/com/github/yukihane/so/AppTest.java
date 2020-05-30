package com.github.yukihane.so;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testApp() {
        Task s1 = new Task();
        s1.setCharge(List.of(new ChargeInitial(1.0), new ChargeInitial(2.0)));
        TaskDTO d1 = App.converTaskToDTO(s1);
        System.out.println(d1);

        Task s2 = new Task();
        s2.setCharge(List.of(new ChargeInitial(3.0), new ChargeInitial(4.0)));
        TaskDTO d2 = App.converTaskToDTO(s2);
        System.out.println(d2);
    }
}
