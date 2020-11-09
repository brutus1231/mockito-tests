package pl.sda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepository {

    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        users.add(User.builder().email("zenek@wp.pl").password("haslo123")
                .registrationDate(new Date()).salary(BigDecimal.TEN).build());
        users.add(User.builder().email("ola@wp.pl").password("ola123")
                .registrationDate(new Date()).salary(BigDecimal.ONE).build());
        return users;
    }

    public void add(User user) {
        System.out.println("Dodano użytkownika do bazy danych");
    }
}
