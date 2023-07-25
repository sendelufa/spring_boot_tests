package ru.karasongs.karasongs.service.song;

import ru.karasongs.karasongs.api.response.SongResponse;
import ru.karasongs.karasongs.model.SongPersist;

public record PersistToResponse(SongPersist song) {
    public SongResponse toResponse() {
        return SongResponse.builder()
                .title(song.getTitle())
                .author(song.getAuthor())
                .genre(song.getGenre())
                .timeLength(new DurationToLengthConverter(song).length())
                .createdAt(song.getAddedAt())
                .build();
    }
}
