package com.github.yukihane.so;

import javax.swing.*;
import java.util.Map;

public class NewOrLoadPanel extends JPanel {
    public DefaultComboBoxModel<String> usernameChoiceList;
    public JRadioButton newCloset = new JRadioButton();
    public JRadioButton loadCloset = new JRadioButton();
    public JButton next;
    public JComboBox usernameChoice;
    ButtonGroup newOrLoad = new ButtonGroup();

    public NewOrLoadPanel(XMLParsed choices) {
        initComponents(choices);
    }

    private void initComponents(XMLParsed choices) {

        newCloset.setText("New Closet File");
        newCloset.setActionCommand("new");
        loadCloset.setText("Load Closet from File...");
        loadCloset.setActionCommand("load");
        newOrLoad.add(newCloset);
        newOrLoad.add(loadCloset);
        next = new JButton("Next");
        add(loadCloset);
        add(newCloset);
        JLabel inputLabel = new JLabel("Choose a username from the list below: ");
        add(inputLabel);

        usernameChoiceList = new DefaultComboBoxModel<>();
        for (Map.Entry<String, String> mapEntry : choices.hexUsernameMap.entrySet()) {
            usernameChoiceList.addElement(mapEntry.getKey());
        }
        usernameChoice = new JComboBox(usernameChoiceList);
        add(usernameChoice);

    }
    public String getSelectedAction() {
        return newOrLoad.getSelection().getActionCommand();
    }
}
