package be.bornput.springjpademo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class UtilHelperClassTest {

    @Test
    void getCustomLocalDateTime() {
        LocalDateTime expectedLocalDate = LocalDateTime.of( 2000, 12, 01, 0, 0, 0);
        LocalDateTime actualLocalDate = UtilHelperClass.getCustomLocalDateTime(2000, 12, 01);
        assertThat(actualLocalDate).isEqualTo(expectedLocalDate);
    }

    @Test
    void getLocalDateForCurrentTime() {
        LocalDate expectedLocalDate = LocalDateTime.now().toLocalDate();
        LocalDate actualLocalDate = UtilHelperClass.getLocalDateForCurrentTime();
        assertThat(actualLocalDate).isEqualTo(expectedLocalDate);
    }

}