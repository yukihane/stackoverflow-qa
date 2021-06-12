package com.example.jaso77488;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.AbstractDiscriminator;

public class MyDiscriminator extends AbstractDiscriminator<ILoggingEvent> {

    @Override
    public String getDiscriminatingValue(final ILoggingEvent e) {

        // ファイル名として利用可能な文字チェックが必要
        final String name = e.getLoggerName().replaceAll("[/\\\\]", "_");
        return name;
    }

    @Override
    public String getKey() {
        return "name";
    }

}
