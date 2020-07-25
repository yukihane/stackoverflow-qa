package com.github.yukihane.so;

import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.TCHAR;

public class App {

    public static void main(final String[] args) {
        final long hWnd = OS.FindWindow(null, new TCHAR(OS.CP_INSTALLED,
            "無題 - メモ帳",
            true));

        System.out.println(hWnd);
    }
}
