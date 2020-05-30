package com.github.yukihane.so;

import java.util.List;
import lombok.Data;

@Data
public class TaskDTO {
    private String lot;
    private String project;
    private String collaborator;
    private List<Double> charge;
}
