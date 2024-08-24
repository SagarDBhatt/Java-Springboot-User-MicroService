package UserMicroServicePkg.Service;

import UserMicroServicePkg.Entity.User;
import UserMicroServicePkg.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    public UserRepository repository;

    public User saveUser(User user){
        log.info("Inside saveUser of UserService");
        return repository.save(user);
    }

    public Optional<User> getUserById(UUID userid){
        log.info("Inside getUserById of UserService with id = " + userid);
        return repository.findUserByUserId(userid);
    }
}
