package ru.karasongs.karasongs.service.song;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.karasongs.karasongs.api.request.SongAddRequest;
import ru.karasongs.karasongs.api.response.SongResponse;
import ru.karasongs.karasongs.model.SongPersist;
import ru.karasongs.karasongs.repository.SongRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public void save(@Nonnull SongAddRequest request) {
        var songPersist = new SongMapper(request).toPersist();
        songRepository.insert(songPersist);
    }

    @Override
    public List<SongResponse> findAll() {
        var songs = songRepository.all();
        return toResponse(songs);
    }

    @Override
    public List<SongResponse> searchByAuthorOrTitle(@Nonnull String query) {
        var songs = songRepository.findByAuthorOrTitle(query);
        return toResponse(songs);
    }

    private static List<SongResponse> toResponse(List<SongPersist> songs) {
        return songs.stream()
                .map(PersistToResponse::new)
                .map(PersistToResponse::toResponse)
                .toList();
    }
}
