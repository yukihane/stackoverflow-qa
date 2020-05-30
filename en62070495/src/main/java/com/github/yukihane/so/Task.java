package com.github.yukihane.so;

import java.util.List;
import lombok.Data;

@Data
public class Task {
    private List<ChargeInitial> charge;
    private Lot lot;
    private Collaborator collaborator;
}
