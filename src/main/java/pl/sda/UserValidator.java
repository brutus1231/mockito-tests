package pl.sda;

public class UserValidator {

    public boolean validate(User user) {
        if (user == null) {
            throw new IllegalStateException();
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return false;
        }
        return true;
    }

}
