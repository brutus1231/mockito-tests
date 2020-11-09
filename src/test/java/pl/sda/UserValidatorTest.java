package pl.sda;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    public void shouldPassValidation() {
        //given
        UserValidator userValidator = new UserValidator();
        User user = User.builder().email("kasia@wp.pl").password("kasia").salary(BigDecimal.TEN).build();

        //when
        boolean validationResult = userValidator.validate(user);
        //then
        assertTrue(validationResult);
    }

}