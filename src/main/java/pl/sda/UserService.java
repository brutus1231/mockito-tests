package pl.sda;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public void addUser(User user) {
        if (userValidator.validate(user)) {
            userRepository.add(user);
            return;
        }
        throw new IllegalStateException("Wrong user data !!");
    }
}
