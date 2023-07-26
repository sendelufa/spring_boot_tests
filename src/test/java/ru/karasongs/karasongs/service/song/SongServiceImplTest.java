package ru.karasongs.karasongs.service.song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.karasongs.karasongs.api.request.SongAddRequest;
import ru.karasongs.karasongs.model.SongPersist;
import ru.karasongs.karasongs.repository.SongRepository;

import java.time.Duration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class SongServiceImplTest {

    final SongRepository repository = mock(SongRepository.class);

    SongService service;

    @BeforeEach
    void setUp() {
        service = new SongServiceImpl(repository);
    }

    @Test
    void save() {
        var request = new SongAddRequest(null,
                "The Birthday Massacre", "4:50", null);
        var songPersist = new SongPersist(null,
                "The Birthday Massacre", Duration.ofSeconds(290), null, null);

        service.save(request);

        verify(repository).insert(songPersist);
        verifyNoMoreInteractions(repository);
    }
}