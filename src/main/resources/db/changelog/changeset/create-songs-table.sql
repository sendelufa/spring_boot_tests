-- Changeset: create-songs (Author: Konstantin Shibkov)
CREATE TABLE IF NOT EXISTS songs
(
    id BIGSERIAL PRIMARY KEY,
    title       TEXT      NOT NULL,
    author      TEXT      NOT NULL,
    time_length BIGINT    NOT NULL,
    genre       TEXT      NULL,
    created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

