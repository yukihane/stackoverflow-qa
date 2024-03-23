package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SplaScheduleGui extends JFrame {
    private JButton regularButton;
    private JButton bankaraButton;
    private JButton xButton;
    private JButton eventButton;
    private JButton festButton;
    private JButton salmonRunButton;
    private JPanel lobbyPanel; // ロビー情報（レギュラーバトル、バンカラマッチ、Xマッチなど）を表示するパネル、フレーム下部に表示
    private JScrollPane scrollPane;

    public SplaScheduleGui() {
        super("Splatoon3 Schedule App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        initButton();
        initPanel();
        initScrollPane();
        addGuiComponents();
        setActionListenerToButton();
    }

    private void initScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
    }

    private void addGuiComponents() {
        add(createButtonPanel(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(lobbyPanel, BorderLayout.SOUTH);
    }

    private void initPanel() {
        lobbyPanel = new L_RegularPanel();
    }

    private void setScheduleAndLobbyPanels(JPanel schedulePanel, JPanel lobbyPanel) {
        scrollPane.setViewportView(schedulePanel);
        add(scrollPane, BorderLayout.CENTER);
        add(lobbyPanel, BorderLayout.SOUTH);
    }

    private void onRegularButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanels(new RegularPanel(), new L_RegularPanel());
    }

    private void onBankaraButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanels(new BankaraPanel(), new L_BankaraPanel());
    }

    private void onXButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanels(new XPanel(), new L_XPanel());
    }

    private void onEventButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanels(new EventPanel(), new L_EventPanel());
    }

    private void onFestButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanels(new FestPanel(), new L_FestPanel());
    }

    private void onSalmonRunButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanels(new SalmonRunPanel(), new L_SalmonRunPanel());
    }

    private void setActionListenerToButton() {
        regularButton.addActionListener(this::onRegularButtonClick);
        bankaraButton.addActionListener(this::onBankaraButtonClick);
        xButton.addActionListener(this::onXButtonClick);
        eventButton.addActionListener(this::onEventButtonClick);
        festButton.addActionListener(this::onFestButtonClick);
        salmonRunButton.addActionListener(this::onSalmonRunButtonClick);
    }

    private void initButton() {
        regularButton = new LobbyButton("src/assets/regular.png");
        bankaraButton = new LobbyButton("src/assets/bankara.png");
        xButton = new LobbyButton("src/assets/x.png");
        eventButton = new LobbyButton("src/assets/event.png");
        festButton = new LobbyButton("src/assets/fest.png");
        salmonRunButton = new LobbyButton("src/assets/salmonrun.png");
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(regularButton);
        buttonPanel.add(bankaraButton);
        buttonPanel.add(xButton);
        buttonPanel.add(eventButton);
        buttonPanel.add(festButton);
        buttonPanel.add(salmonRunButton);
        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplaScheduleGui scheduleGui = new SplaScheduleGui();
            scheduleGui.setVisible(true);
        });
    }
}
