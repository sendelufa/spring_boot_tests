package ru.karasongs.karasongs.api.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.With;

import java.time.Instant;

@Builder
@With
public record SongResponse(
        @NotNull String title,
        @NotNull String author,
        @NotNull String timeLength,
        String genre,
        @NotNull Instant createdAt
) {
}
