package pl.sda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

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
        User user = User.builder().email("kasia@wp.pl").password("kasia123").salary(BigDecimal.TEN).build();

        UserService userService = new UserService(userRepository, userValidator);
        //when
        userService.addUser(user);
        //then
        Mockito.verify(userValidator).validate(user);
        Mockito.verify(userRepository).add(user);
    }
}