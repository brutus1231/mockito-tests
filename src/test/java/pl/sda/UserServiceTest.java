package pl.sda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @Test
    public void shouldTestAddUser() {
        //given
        UserService userService = new UserService(userRepository, userValidator);
        //when

        //then
    }
}