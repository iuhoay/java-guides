package dev.iuhoay.java.service;

import dev.iuhoay.java.dto.UserDTO;
import dev.iuhoay.java.dto.mapper.UserDTOMapper;
import dev.iuhoay.java.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDTOMapper userDTOMapper;


    public List<UserDTO> getUsers() {
        List<User> userList = List.of(
                User.builder().firstName("John").lastName("Doe").age(30).createdAt(LocalDateTime.parse("2021-01-01T00:00:00")).build(),
                User.builder().firstName("Jane").lastName("Doe").age(25).createdAt(LocalDateTime.parse("2021-01-01T00:00:00")).build()
        );
        return userList.stream().map(userDTOMapper).toList();
    }
}
