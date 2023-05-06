package dev.iuhoay.java.dto.mapper;

import dev.iuhoay.java.dto.UserDTO;
import dev.iuhoay.java.entity.User;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Function;

public class UserDTOMapper implements Function<User, UserDTO> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                Optional.ofNullable(user.getCreatedAt())
                        .map(createAt -> createAt.format(DATE_TIME_FORMATTER))
                        .orElse(null)
        );
    }
}
