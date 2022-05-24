package com.github.yukihane.examples;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class App {
    private static final int RESOLUTION = 30;

    public static void main(final String[] args) throws IOException, InterruptedException {
        final DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        final Terminal terminal = defaultTerminalFactory.createTerminal();

        terminal.clearScreen();
        terminal.setCursorPosition(0, 0);
        terminal.putString("実行開始");

        for (int i = 1; i <= RESOLUTION; i++) {
            terminal.setCursorPosition(0, 1);

            final int color = 255 * i / RESOLUTION;
            terminal.setForegroundColor(new TextColor.RGB(color, color, color));
            terminal.putString("Hello, world!");
            terminal.flush();
            Thread.sleep(3000L / RESOLUTION);
        }
        terminal.setCursorPosition(0, 2);
    }
}
