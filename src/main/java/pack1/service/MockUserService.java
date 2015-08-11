package pack1.service;

import org.springframework.stereotype.Service;
import pack1.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihai7 on 7/15/2015.
 */
@Service
public class MockUserService implements IUserService {

    @Override
    public List<User> findAllUsers() {
        User user1 = new User();
        user1.setLastname("Robin");
        user1.setFirstname("First");

        User user2 = new User();
        user2.setLastname("Batman");
        user2.setFirstname("Second");
        User user3 = new User();
        user3.setLastname("Joker");
        user3.setFirstname("Third");


       ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }
}
