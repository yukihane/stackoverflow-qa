package com.github.yukihane.so;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.Data;

public class App {

    @Data
    public static class car {
        private long carId;

        public long carId() {
            return getCarId();
        }
    }

    private long carId;

    public static void main(final String[] args) {
        new App().method();
    }

    public void method() {
        final List<car> carList = List.of();

        // boolean isExist = false;  //エラーになる
        final AtomicBoolean isExist = new AtomicBoolean(false);
        for (final car c : carList) {
            if (c.carId() == this.carId) {
                isExist.set(true);
            }
        }

        carList.stream()
            .filter(c -> c.getCarId() == this.carId)
            .forEach(i -> isExist.set(true));
    }
}
