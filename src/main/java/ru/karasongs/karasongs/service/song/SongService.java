package ru.karasongs.karasongs.service.song;

import jakarta.annotation.Nonnull;
import ru.karasongs.karasongs.api.request.SongAddRequest;
import ru.karasongs.karasongs.api.response.SongResponse;

import java.util.List;

public interface SongService {
    void save(@Nonnull SongAddRequest request);

    List<SongResponse> findAll();

    List<SongResponse> searchByAuthorOrTitle(@Nonnull String query);
}
