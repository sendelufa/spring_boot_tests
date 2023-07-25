package ru.karasongs.karasongs.service.song;

import lombok.RequiredArgsConstructor;
import ru.karasongs.karasongs.api.request.SongAddRequest;

import java.time.Duration;

@RequiredArgsConstructor
class LengthToDurationConverter {

    public static final String TIME_DELIMITER = ":";
    public static final int MINUTES_INDEX = 0;
    public static final int SECONDS_INDEX = 1;

    private final SongAddRequest songAddRequest;

    public Duration duration() {
        var timesArray = songAddRequest.timeLength().split(TIME_DELIMITER);
        var minutes = Integer.parseInt(timesArray[MINUTES_INDEX]);
        var seconds = Integer.parseInt(timesArray[SECONDS_INDEX]);

        return Duration.ofMinutes(minutes).plusSeconds(seconds);
    }
}
