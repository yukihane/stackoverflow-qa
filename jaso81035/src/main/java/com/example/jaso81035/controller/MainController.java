package com.example.jaso81035.controller;

import com.example.jaso81035.entity.Week;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(final Model model) {
        // カレンダーのインスタンス
        final Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DATE);

        // 今月の始まり
        calendar.set(year, month, 1);
        final int startWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 先月分の日数
        calendar.set(year, month, 0);
        final int beforeMonthlastDay = calendar.get(Calendar.DATE);

        // 今月分の日数
        calendar.set(year, month + 1, 0);
        final int thisMonthlastDay = calendar.get(Calendar.DATE);

        final Week week = new Week();
        final int[] calday = new int[42]; // 最大で7日6週
        final List<Integer> weeklist = new ArrayList<>();
        int count = 0;

        // 先月分の日付を格納
        for (int i = startWeek - 2; i >= 0; i--) {
            calday[count++] = beforeMonthlastDay - i;
        }

        // 今月分の日付を格納
        for (int i = 1; i <= thisMonthlastDay; i++) {
            calday[count++] = i;
        }

        // 翌月分の日付を格納
        int nextMonthDay = 1;
        while (count % 7 != 0) {
            calday[count++] = nextMonthDay++;
        }

        final int weekCount = count / 7;

        for (int i = 0; i < weekCount; i++) {
            for (int j = i * 7; j < i * 7 + 7; j++) {

                if (calday[j] < 10) {
                    //                  System.out.println(calday[j]);
                } else {
                    //                  System.out.println(calday[j]);
                }
                weeklist.add(calday[j]);
                week.setWeekdays(weeklist);
            }
        }

        model.addAttribute("weekday", week.getWeekdays());
        System.out.println(week.getWeekdays());

        return "index";
    }

}
