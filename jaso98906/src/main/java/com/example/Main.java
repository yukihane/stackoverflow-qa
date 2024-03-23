package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class Main extends JFrame {
    private final JButton topButton;

    private JPanel panel;

    public Main() {
        super("Main");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        topButton = new JButton("Refresh");
        topButton.addActionListener(this::onTopButtonClick);
        add(topButton, BorderLayout.NORTH);

        panel = newCenterPane();
        add(panel, BorderLayout.SOUTH);

    }

    private void onTopButtonClick(ActionEvent actionEvent) {
        var newPane = newCenterPane();
        setPanel(newPane);
    }

    private void setPanel(JPanel panel) {
        remove(this.panel);

        // ①
        // 次回setPanel()を呼んだときにremoveするために
        // 引数のパネルをpanelフィールドに保持する
        this.panel = panel;

        // ②
        // 引数のパネルを表示
        this.add(panel, BorderLayout.SOUTH);

        validate();
    }

    private static JPanel newCenterPane() {
        var panel = new JPanel();
        var label = new JLabel(ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        panel.add(label);
        return panel;
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new Main();
            frame.setVisible(true);
        });
    }
}
