package ru.itis.security.course;

public enum Course {
    FIRST_COURSE(2), SECOND_COURSE(2), THIRD_COURSE(3), FOUTH_COURSE(4);

    private final int value;

    private Course(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
