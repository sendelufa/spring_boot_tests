package ru.karasongs.karasongs.service.song;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.karasongs.karasongs.api.request.SongAddRequest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LengthToDurationConverterTest {

    @ParameterizedTest
    @CsvSource({ "0,0:00", "5,0:05", "90,1:30", "122, 2:02" })
    @DisplayName("Convert from Length to Duration is Success!")
    void duration_success(int expected, String lengthSong) {
        var request = new SongAddRequest(null,
                "The Birthday Massacre", lengthSong, null);

        var converter = new LengthToDurationConverter(request);

        var duration = converter.duration();

        assertThat(duration).isEqualTo(Duration.ofSeconds(expected));
    }
}