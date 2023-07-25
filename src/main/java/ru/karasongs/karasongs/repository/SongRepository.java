package ru.karasongs.karasongs.repository;

import jakarta.annotation.Nonnull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import ru.karasongs.karasongs.model.SongPersist;
import ru.karasongs.karasongs.model.types.DurationTypeHandler;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Mapper
public interface SongRepository {
    @Select("SELECT * FROM songs")
    @Result(column = "time_length", property = "duration", javaType = Duration.class,
            typeHandler = DurationTypeHandler.class)
    @Result(column = "created_at", property = "addedAt", javaType = Instant.class)
    List<SongPersist> all();

    @Select("SELECT * FROM songs WHERE title LIKE CONCAT('%', #{query}, '%') OR author LIKE CONCAT('%', #{query}, '%')")
    @Result(column = "time_length", property = "duration", javaType = Duration.class,
            typeHandler = DurationTypeHandler.class)
    @Result(column = "created_at", property = "addedAt", javaType = Instant.class)
    List<SongPersist> findByAuthorOrTitle(@Nonnull String query);

    @Insert("INSERT INTO songs (title, author, time_length, genre) VALUES (#{title}, #{author}, #{duration}, #{genre})")
    void insert(SongPersist song);
}
