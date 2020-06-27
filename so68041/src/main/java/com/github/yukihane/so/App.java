package com.github.yukihane.so;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        // 2020/06/27 00:54:01 557 (JST)
        // 注: 第7引数はミリ秒でなくナノ秒
        final OffsetDateTime datetime = OffsetDateTime.of(2020, 6, 27, 0, 54, 1, 557_000_000, ZoneOffset.ofHours(9));
        // final ZonedDateTime datetime = ZonedDateTime.of(2020, 6, 27, 0, 54, 1, 557_000_000,
        //     ZoneId.of("JST", ZoneId.SHORT_IDS));
        final Date date = Date.from(datetime.toInstant());
        System.out.println(date);
        System.out.println(date.getTime());
    }
}
