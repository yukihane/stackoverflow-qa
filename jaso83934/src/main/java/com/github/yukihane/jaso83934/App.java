package com.github.yukihane.jaso83934;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class App {
    public static void main(final String[] args) {
        final LocalDate base = LocalDate.now(); // 2021-12-03

        // 当月(2021-12) の 2 回目の水曜日
        final LocalDate date = base.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY));

        System.out.println(date); // 2021-12-08
    }
}
