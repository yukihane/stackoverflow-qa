package com.github.yukihane.so;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Num_Array2 {

    public static void main(final String[] args) throws FileNotFoundException, IOException {

        final List<Line> total;
        try (BufferedReader br = new BufferedReader(new FileReader("1041.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("1042.txt"))) {
            total = sum(br, br2);
        }
        write(total);

    }

    private static List<Line> sum(final BufferedReader br, final BufferedReader br2) throws IOException {
        final List<Line> ret = new ArrayList<>();

        while (true) {
            final Line l1 = Line.from(br.readLine());
            final Line l2 = Line.from(br2.readLine());
            if (l1.isNullLine() && l2.isNullLine()) {
                return ret;
            }
            final Line sum = Line.sum(l1, l2);
            ret.add(sum);
        }
    }

    private static void write(final List<Line> total) throws IOException {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output104.txt")))) {
            total.forEach(line -> {
                final String lineStr = line.toString();
                try {
                    writer.write(lineStr);
                    writer.newLine();
                } catch (final IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }
    }

    /**
     * ファイル中の「行」を表現するクラス。
     */
    public static class Line {

        private final List<Integer> list;
        private final boolean nullLine;

        /**
         * 行と行を足し合わせて結果を得ます。
         */
        public static Line sum(final Line l1, final Line l2) {
            if (l1.isNullLine() && l2.isNullLine()) {
                return new Line(List.of(), true);
            }

            final List<Integer> sum = new ArrayList<>();
            final Iterator<Integer> i1 = l1.list.iterator();
            final Iterator<Integer> i2 = l2.list.iterator();
            while (i1.hasNext() || i2.hasNext()) {
                final int num1 = i1.hasNext() ? i1.next().intValue() : 0;
                final int num2 = i2.hasNext() ? i2.next().intValue() : 0;
                sum.add(Integer.valueOf(num1 + num2));
            }
            return new Line(sum, false);
        }

        /**
         * ファイル中の文字列から行を得ます。
         */
        public static Line from(final String str) {
            if (str == null) {
                return new Line(List.of(), true);
            } else if (str.isEmpty()) {
                return new Line(List.of(), false);
            } else {
                final List<Integer> list = List.of(str.split(","))
                    .stream().map(e -> {
                        if (e.isEmpty()) {
                            return 0;
                        } else {
                            return Integer.parseInt(e);
                        }
                    })
                    .collect(Collectors.toList());
                return new Line(list, false);
            }
        }

        private Line(final List<Integer> list, final boolean nullLine) {
            this.list = list;
            this.nullLine = nullLine;
        }

        /**
         * ファイル終端を表す行であるかを判定します。
         */
        public boolean isNullLine() {
            return nullLine;
        }

        public String[] toStringArray() {
            return list.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
        }

        @Override
        public String toString() {
            return String.join(",", toStringArray());
        }
    }
}
