package com.github.yukihane.examples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setText("Snippet 100");
        shell.setBounds(10, 10, 200, 200);
        final Text text = new Text(shell, SWT.MULTI);
        final Rectangle clientArea = shell.getClientArea();
        text.setBounds(clientArea.x + 10, clientArea.y + 10, 150, 150);
        final Font initialFont = text.getFont();
        final FontData[] fontData = initialFont.getFontData();
        for (final FontData element : fontData) {
            element.setHeight(24);
        }
        final Font newFont = new Font(display, fontData);
        text.setFont(newFont);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        newFont.dispose();
        display.dispose();
    }
}
