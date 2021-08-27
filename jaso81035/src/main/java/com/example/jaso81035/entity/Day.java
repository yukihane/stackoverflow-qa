package com.example.jaso81035.entity;

public class Day {
    /** 日付 */
    private int dayOfMonth;
    /** 今日を表しているならtrue */
    private boolean isToday;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(final int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public boolean isToday() {
        return isToday;
    }

    public void setToday(final boolean isToday) {
        this.isToday = isToday;
    }

}
