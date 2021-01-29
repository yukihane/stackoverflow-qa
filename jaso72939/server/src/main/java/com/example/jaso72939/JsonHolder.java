package com.example.jaso72939;

import java.util.List;
import lombok.Data;

@Data
public class JsonHolder {
    private boolean success;
    private int data_size;
    private List<Object> data_list;
}
