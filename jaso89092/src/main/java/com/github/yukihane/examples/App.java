package com.github.yukihane.examples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setBounds(10, 10, 200, 200);

        final Label label = new Label(shell, SWT.NONE | SWT.BORDER);
        //        final Font font = new Font(Display.getDefault(), "Arial", 8, SWT.NONE);
        final FontData[] fontData = label.getFont().getFontData();
        for (final FontData fd : fontData) {
            fd.setName("Arial");
            fd.setHeight(8);
            fd.setStyle(SWT.NONE);
        }
        final Font font = new Font(Display.getDefault(), fontData);
        label.setFont(font);
        label.setText("Hello, world! Hello, world! Hello, world!");

        final FormLayout layout = new FormLayout();
        layout.marginWidth = layout.marginHeight = 5;
        shell.setLayout(layout);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        font.dispose();
        display.dispose();
    }
}
