package ru.karasongs.karasongs.service.song;

import lombok.RequiredArgsConstructor;
import ru.karasongs.karasongs.api.request.SongAddRequest;
import ru.karasongs.karasongs.model.SongPersist;

@RequiredArgsConstructor
class SongMapper {

    private final SongAddRequest songAddRequest;

    public SongPersist toPersist() {
        if (songAddRequest == null) {
            return null;
        }

        return SongPersist.builder()
                .title(songAddRequest.title())
                .author(songAddRequest.author())
                .genre(songAddRequest.genre())
                .duration(new LengthToDurationConverter(songAddRequest).duration())
                .build();
    }
}
