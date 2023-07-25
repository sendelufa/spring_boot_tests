package ru.karasongs.karasongs.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public final class SongPersist {
    private @NotNull String title;
    private @NotNull String author;
    private @NotNull Duration duration;
    private String genre;
    private Instant addedAt;
}
