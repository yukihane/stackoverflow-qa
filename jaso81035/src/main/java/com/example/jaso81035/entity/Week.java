package com.example.jaso81035.entity;

import java.util.ArrayList;
import java.util.List;

public class Week {
    // 1週(7日間)を管理するListを、 1月分Listで保持
    private List<List<Integer>> weekList = new ArrayList<>();

    public List<List<Integer>> getWeekList() {
        return weekList;
    }

    public void setWeekList(final List<List<Integer>> weekList) {
        this.weekList = weekList;
    }
}