package be.bornput.springjpademo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilHelperClassTest {

    @Test
    void getCustomLocalDateTime() {
        LocalDateTime expectedLocalDate = LocalDateTime.of( 2000, 12, 01, 0, 0, 0);
        LocalDateTime actualLocalDate = UtilHelperClass.getCustomLocalDateTime(2000, 12, 01);
        assertThat(actualLocalDate.equals(expectedLocalDate));
    }

    @Test
    void getLocalDateForCurrentTime() {
        LocalDate expectedLocalDate = LocalDateTime.now().toLocalDate();
        LocalDate actualLocalDate = UtilHelperClass.getLocalDateForCurrentTime();
        assertThat(actualLocalDate.equals(expectedLocalDate));
    }

}