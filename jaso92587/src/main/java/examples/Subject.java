package examples;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Subject {
    JAPANESE("国語"),
    MATH("数学"),
    ENGLISH("英語"),
    ;

    private final String value;

    public static Subject from(String value) {
        for (Subject s : Subject.values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Illegal value: " + value);
    }
}
