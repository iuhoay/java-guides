package dev.iuhoay.java.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDTOTest {

    @Test
    void testGetFullName() {
        UserDTO userDTO = new UserDTO("John", "Doe", 30, "2021-01-01T00:00:00");
        assertEquals("John Doe", userDTO.getFullName());
    }
}
