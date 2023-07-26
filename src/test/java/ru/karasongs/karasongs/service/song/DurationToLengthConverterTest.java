package ru.karasongs.karasongs.service.song;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.karasongs.karasongs.model.SongPersist;
import ru.karasongs.karasongs.service.song.DurationToLengthConverter;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


class DurationToLengthConverterTest {

    @ParameterizedTest
    @CsvSource({ "0,0:00", "5,0:05", "90,1:30", "122, 2:02" })
    void length_success(int seconds, String expected) {

        var songPersist = SongPersist.builder()
                .duration(Duration.ofSeconds(seconds))
                .build();

        var converter = new DurationToLengthConverter(songPersist);
        var length = converter.length();
        assertThat(length).isEqualTo(expected);
    }
}