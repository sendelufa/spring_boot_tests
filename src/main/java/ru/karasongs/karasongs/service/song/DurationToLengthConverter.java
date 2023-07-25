package ru.karasongs.karasongs.service.song;

import lombok.RequiredArgsConstructor;
import ru.karasongs.karasongs.model.SongPersist;

@RequiredArgsConstructor
class DurationToLengthConverter {

    public static final String TIME_FORMAT = "%d:%02d";
    private final SongPersist song;

    public String length() {
        var minutes = song.getDuration().toMinutes();
        var seconds = song.getDuration().toSeconds() - minutes * 60;
        return String.format(TIME_FORMAT, minutes, seconds);
    }
}
