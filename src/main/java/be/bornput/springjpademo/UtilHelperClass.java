package be.bornput.springjpademo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UtilHelperClass {

    public static LocalDateTime getCustomLocalDateTime(int month, int year, int day) {
        return LocalDate.of(month, year, day).atStartOfDay();
    }

    public static LocalDate getLocalDateForCurrentTime() {
        return LocalDateTime.now().toLocalDate();

    }
}

