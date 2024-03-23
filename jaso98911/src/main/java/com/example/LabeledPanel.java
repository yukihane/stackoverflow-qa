package com.example;

import javax.swing.*;

public class LabeledPanel extends JPanel {
    public LabeledPanel() {
        var label = new JLabel(getClass().getSimpleName());
        add(label);
    }
}
