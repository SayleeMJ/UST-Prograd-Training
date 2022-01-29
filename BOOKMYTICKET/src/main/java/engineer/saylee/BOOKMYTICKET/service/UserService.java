package engineer.saylee.BOOKMYTICKET.service;


import engineer.saylee.BOOKMYTICKET.entity.User;
import engineer.saylee.BOOKMYTICKET.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean existsById(String username) {
        return userRepository.existsById(username);
    }

    public User findByUsername(String username) {

        return userRepository.getById(username);

    }

}
