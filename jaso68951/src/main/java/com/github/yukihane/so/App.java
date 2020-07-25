package com.github.yukihane.so;

public class App {

    public static void main(final String[] args) {
        final int hWnd = OS.FindWindow(null, new TCHAR(OS.CP_INSTALLED, "(無題) - 秀丸",
            true));
    }
}
