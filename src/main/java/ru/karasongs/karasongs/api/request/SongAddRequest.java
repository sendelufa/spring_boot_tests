package ru.karasongs.karasongs.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SongAddRequest(
        @NotNull String title,
        @NotNull String author,
        @NotNull @Pattern(regexp = "^[0-9]{1,4}:[0-9]{1,2}$") String timeLength,
        String genre
) {
}
