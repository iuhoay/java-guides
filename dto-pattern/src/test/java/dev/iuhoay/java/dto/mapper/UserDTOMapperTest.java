package dev.iuhoay.java.dto.mapper;

import dev.iuhoay.java.dto.UserDTO;
import dev.iuhoay.java.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDTOMapperTest {
    private final UserDTOMapper userDTOMapper = new UserDTOMapper();

    @Test
    void testConvertUserToUserDTO() {
        User user = new User("John", "Doe", 30, LocalDateTime.parse("2021-01-01T00:00:00"));

        UserDTO userDTO = userDTOMapper.apply(user);

        assertEquals("John Doe", userDTO.getFullName());
        assertEquals(30, userDTO.age());
        assertEquals("John", userDTO.firstName());
        assertEquals("Doe", userDTO.lastName());
    }

    @Test
    void testConvertListUserToListUserDTO() {
        List<User> userList = Arrays.asList(
                new User("John", "Doe", 30, LocalDateTime.parse("2021-01-01T00:00:00")),
                new User("Jane", "Doe", 25, LocalDateTime.parse("2021-01-01T00:00:00"))
        );

        List<UserDTO> userDTOList = userList.stream().map(userDTOMapper).toList();

        assertEquals(2, userDTOList.size());
        assertEquals("John Doe", userDTOList.get(0).getFullName());
        assertEquals("2021-01-01 00:00:00", userDTOList.get(0).createdAt());
        assertEquals("Jane Doe", userDTOList.get(1).getFullName());
    }

}
