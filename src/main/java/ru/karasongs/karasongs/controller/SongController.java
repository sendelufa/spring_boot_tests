package ru.karasongs.karasongs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.karasongs.karasongs.api.request.SongAddRequest;
import ru.karasongs.karasongs.api.response.SongResponse;
import ru.karasongs.karasongs.service.song.SongService;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService service;

    @PostMapping("/")
    public void add(@RequestBody @Validated SongAddRequest request) {
        service.save(request);
    }

    @GetMapping("/")
    public List<SongResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/search/{query}")
    public List<SongResponse> search(@PathVariable("query") String query) {
        return service.searchByAuthorOrTitle(query);
    }
}
