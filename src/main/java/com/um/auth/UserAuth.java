package com.um.auth;
import com.um.models.DataLog;
import org.springframework.beans.factory.annotation.Autowired;
import com.um.util.JWTUtil;
import com.um.util.ResponseUtil;
import com.um.models.User;
import org.springframework.stereotype.Component;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import com.um.repositories.UserRepository;


@Component
public class UserAuth {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    public User userLogged(User user){
        // User current_user = (User) userRepository.getUserByEmail(user);
        User current_user = (User) userRepository.getUserByEmail(user.getEmail());

        String passwordHash = current_user.getPassword();

        if (this.verifyPassword(user.getPassword(), passwordHash)) {
            return current_user;
        }
        return null;
    }

    public ResponseUtil createToken(User current_user) {
        if(current_user != null){
            String token = jwtUtil.create(String.valueOf(current_user.getId()), current_user.getEmail());
            DataLog data = new DataLog(token, current_user.getId());
            return new ResponseUtil("Token succesfully generated", true, 200, data);
        }
        return new ResponseUtil("Incorrect credentials", false, 401, null);
    }

    public String generatePasswordHash(String password) {
        return argon2.hash(1, 1024, 1, password);
    }

    public boolean verifyPassword(String password, String hash) {
        return argon2.verify(hash, password);
    }

    public ResponseUtil verifyEmailDuplicated(User user){
        // User new_user = (User) userRepository.getUserByEmail(user);
        User new_user = (User) userRepository.getUserByEmail(user.getEmail());

        if(new_user != null){
            return new ResponseUtil("Email already exits", false, 409, null);       
        }

        String password = this.generatePasswordHash(user.getPassword());
        user.setPassword(password);
        // userRepository.create(user);
        userRepository.save(user);

        // user.setPassword(null);
        return new ResponseUtil("User succesfully created", true, 200, null);
    }

}