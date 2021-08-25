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

        // 今月1日
        calendar.clear();
        calendar.set(year, month, 1);

        // 今月1日を含む週の始まり(日曜日) = カレンダーの初日
        final Calendar firstDayOfCalendar = (Calendar) calendar.clone();
        firstDayOfCalendar.add(Calendar.DATE, Calendar.SUNDAY - firstDayOfCalendar.get(Calendar.DAY_OF_WEEK));

        System.out.print("今月1日を含む週の始まり(日曜日) = カレンダーの初日: ");
        System.out.printf("%d %d %d\n", firstDayOfCalendar.get(Calendar.YEAR), firstDayOfCalendar.get(Calendar.MONTH),
            firstDayOfCalendar.get(Calendar.DAY_OF_MONTH));

        // 今月末日を含む週の終わり(土曜日) = カレンダーの末日
        final Calendar lastDayOfCalendar = (Calendar) calendar.clone();
        lastDayOfCalendar.add(Calendar.MONTH, 1);
        lastDayOfCalendar.add(Calendar.DAY_OF_MONTH, -1);
        lastDayOfCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

        System.out.print("今月末日を含む週の終わり(土曜日) = カレンダーの末日: ");
        System.out.printf("%d %d %d\n", lastDayOfCalendar.get(Calendar.YEAR), lastDayOfCalendar.get(Calendar.MONTH),
            lastDayOfCalendar.get(Calendar.DAY_OF_MONTH));

        final List<List<Integer>> weeklist = new ArrayList<>();
        final Calendar day = (Calendar) firstDayOfCalendar.clone();
        while (day.compareTo(lastDayOfCalendar) <= 0) {

            final List<Integer> weekDays = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                weekDays.add(day.get(Calendar.DAY_OF_MONTH));
                day.add(Calendar.DATE, 1);

            }
            weeklist.add(weekDays);
        }

        System.out.println("カレンダー: " + weeklist);

        final Week week = new Week();
        week.setWeekList(weeklist);

        model.addAttribute("week", week);
        return "index";
    }

}
