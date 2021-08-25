package com.example.jaso81035.entity;

import java.util.ArrayList;
import java.util.List;

public class Week {
    private List<Integer> weekdays = new ArrayList<>();

    public List<Integer> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(final List<Integer> weekdays) {
        this.weekdays = weekdays;
    }
}