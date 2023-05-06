package dev.iuhoay.java.controller;

import dev.iuhoay.java.dto.UserDTO;
import dev.iuhoay.java.dto.mapper.UserDTOMapper;
import dev.iuhoay.java.entity.User;
import dev.iuhoay.java.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserDTOMapper userDTOMapper;
    @MockBean
    UserService userService;

    @Test
    void getUsers() throws Exception {
        // Given
        List<User> userList = List.of(
                new User("John", "Doe", 30, LocalDateTime.parse("2021-01-01T00:00:00")),
                new User("Jane", "Doe", 25, LocalDateTime.parse("2021-01-01T00:00:00"))
        );
        List<UserDTO> userDTOList = userList.stream().map(userDTOMapper).toList();

        // When
        when(userService.getUsers()).thenReturn(userDTOList);

        // Then
        mockMvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].first_name").value("John"))
                .andExpect(jsonPath("$.[0].last_name").value("Doe"))
                .andExpect(jsonPath("$.[0].age").value(30))
                .andExpect(jsonPath("$.[0].full_name").value("John Doe"))
                .andExpect(jsonPath("$.[0].created_at").value("2021-01-01 00:00:00"))
        ;
    }
}
