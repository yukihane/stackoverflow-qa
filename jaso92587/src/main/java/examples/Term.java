package examples;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Term {
    T1(1),
    T2(2),
    ;

    private final int value;

    public static Term from(int value) {
        for (Term t : Term.values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("Illegal value: " + value);
    }
}
