package be.bornput.springjpademo.model;

import be.bornput.springjpademo.UtilHelperClass;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class BookTest {

    private Book bookUnderTest;
    private final LocalDateTime fixLocalDateNow = UtilHelperClass.getCustomLocalDateTime(2000,12,1);;

    @Test
    public void test_createNewBookWithConstructorAndRetrieveItsProperties() {
        bookUnderTest = new Book ("Add 4th book to collection",  fixLocalDateNow);
        bookUnderTest.setId(4L);
        Book bookToCompareWith = new Book ("Add 4th book to collection",  fixLocalDateNow);
        bookToCompareWith.setId(4L);
        assertThat(bookUnderTest).isNotNull();
        assertThat(bookUnderTest.toString()).isEqualTo("Book{id=4, title='Add 4th book to collection', datePublished=2000-12-01}");
        assertThat(bookUnderTest.getTitle()).isEqualTo("Add 4th book to collection");
        assertThat(bookUnderTest.getDateCreated().toLocalDate()).isEqualTo(fixLocalDateNow.toLocalDate());
        assertThat(bookUnderTest).isEqualTo(bookToCompareWith);
        assertThat(bookUnderTest.toString()).isEqualTo(bookToCompareWith.toString());
        assertThat(bookUnderTest.hashCode()).isEqualTo(bookToCompareWith.hashCode());
    }

    @Test
    public void test_createNewBookWithEmptyConstructorAndSetAndRetrieveItsProperties() {
        bookUnderTest = new Book ();
        bookUnderTest.setTitle("Add 4th book to collection");
        bookUnderTest.setId(4L);
        assertThat(bookUnderTest).isNotNull();
        assertThat(bookUnderTest.getId()).isEqualTo(4L);
        assertThat(bookUnderTest.toString()).isEqualTo("Book{id=4, title='Add 4th book to collection', datePublished=" + LocalDateTime.now().toLocalDate() + "}");
        assertThat(bookUnderTest.getTitle()).isEqualTo("Add 4th book to collection");
        assertThat(bookUnderTest.getDateCreated().toLocalDate()).isEqualTo(LocalDateTime.now().toLocalDate());
        assertThat(bookUnderTest.hashCode()).isEqualTo(509466703);
    }

}