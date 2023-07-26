package ru.karasongs.karasongs.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.karasongs.karasongs.service.song.SongService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SongService songService;

    @Test
    void add() throws Exception {
        var content = """
                {
                  "title": "Nothing Else Matters",
                  "author": "Metallica",
                  "timeLength": "6:01"
                }
                """;

        mockMvc.perform(post("/api/songs/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk());

        verify(songService).save(any());
    }

    @Test
    void add_wrongRequest_then_400() throws Exception {
        var content = """
                {
                  "title": "Nothing Else Matters",
                  "author": "Metallica",
                  "timeLength": "601"
                }
                """;

        mockMvc.perform(post("/api/songs/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isBadRequest());

        verifyNoMoreInteractions(songService);
    }

    @Test
    void search() throws Exception {

        mockMvc.perform(get("/api/songs/search/{query}", "Me"))
                .andExpect(status().isOk());

        verify(songService).searchByAuthorOrTitle("Me");
    }
}