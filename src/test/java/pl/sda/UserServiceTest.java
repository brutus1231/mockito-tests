package pl.sda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Executable;
import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
        Mockito.when(userValidator.validate(user)).thenReturn(true);
        userService.addUser(user);
        //then
        Mockito.verify(userValidator).validate(user);
        Mockito.verify(userRepository).add(user);
        Mockito.verifyNoMoreInteractions(userValidator);
        Mockito.verifyNoMoreInteractions(userRepository);
        Assertions.assertDoesNotThrow(() -> userService.addUser(user));
    }

    @Test
    public void shouldThrowExceptionWhenNoUser() {
        //given
        User user = null;
        UserService userService = new UserService(userRepository, userValidator);
        //when
        Mockito.when(userValidator.validate(user)).thenReturn(false);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> userService.addUser(user));
    }
}