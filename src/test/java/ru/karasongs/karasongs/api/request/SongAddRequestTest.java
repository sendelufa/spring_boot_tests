package ru.karasongs.karasongs.api.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SongAddRequestTest {

    private Validator validator;

    @BeforeEach
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static Stream<String> validTimeLength() {
        return Stream.of("0:00", "10:10", "60:00", "0:70", "100:00", "1000:00");
    }

    @ParameterizedTest
    @MethodSource("validTimeLength")
    public void testValidSongAddRequest(String timeLength) {
        // Создаем экземпляр SongAddRequest с валидными значениями
        var songAddRequest = new SongAddRequest("Title", "Author", timeLength, "Genre");

        // Проверяем, что валидация проходит успешно
        Set<ConstraintViolation<SongAddRequest>> violations = validator.validate(songAddRequest);
        assertTrue(violations.isEmpty(), String.format("timeLength=%s is not valid, %s", timeLength, violations));
    }

    @ParameterizedTest
    @MethodSource("validTimeLength")
    public void testValidSongAddRequestAssertJ(String timeLength) {
        var songAddRequest = new SongAddRequest("Title", "Author", timeLength, "Genre");

        var violations = validator.validate(songAddRequest);
        assertThat(violations).isEmpty();
    }
}