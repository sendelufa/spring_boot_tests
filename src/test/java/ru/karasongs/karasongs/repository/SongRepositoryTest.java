package ru.karasongs.karasongs.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.karasongs.karasongs.model.SongPersist;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class SongRepositoryTest {

    @Autowired
    SongRepository songRepository;

    @Container
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:13.5");

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    @Transactional
    void all() {
        var songPersist = SongPersist.builder()
                .title("t1")
                .author("a1")
                .genre("g")
                .duration(Duration.ZERO).build();
        songRepository.insert(songPersist);

        var songs = songRepository.all();
        assertThat(songs).hasSize(1);
    }

    @Test
    @Transactional
    void all_one_more() {
        var songPersist = SongPersist.builder()
                .title("t1")
                .author("a1")
                .genre("g")
                .duration(Duration.ZERO).build();
        songRepository.insert(songPersist);

        var songs = songRepository.all();
        assertThat(songs).hasSize(1);
    }
}