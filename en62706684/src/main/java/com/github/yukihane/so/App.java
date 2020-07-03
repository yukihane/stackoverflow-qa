package com.github.yukihane.so;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class App {

    public static void main(String[] args) {
        new App().newOrLoadChooser();
    }
    private void newOrLoadChooser() {
        XMLParsed hexUserObject = new XMLParsed();
        NewOrLoadPanel dialogPanel = new NewOrLoadPanel(hexUserObject);

        int result = JOptionPane.showConfirmDialog(null, dialogPanel, "", JOptionPane.OK_CANCEL_OPTION);
        boolean isLoadCloset = dialogPanel.loadCloset.isSelected();
        boolean isNewCloset = dialogPanel.newCloset.isSelected();

        boolean userChoice = dialogPanel.getComponent(1).isFocusOwner();
        System.out.println(isLoadCloset);
        System.out.println(isNewCloset);
//        if (userChoice == true) { // new file
//            newClosetChooser();
//            myInv = new ParsedInventory(hexValue, username);
//            validateFolders(myInv.getUsername());
//        }
//        else {
//            myInv = loadInventoryFile();
//            validateFolders(myInv.getUsername());
//
//        }

    }
    private void newClosetChooser() {
        // TODO Auto-generated method stub
        
    }
}
