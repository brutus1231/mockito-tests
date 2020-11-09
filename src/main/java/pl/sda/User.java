package pl.sda;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class User {

    private String email;
    private String password;
    private Date registrationDate;
    private BigDecimal salary;

}
