package com.springbootpracticemvn.webservices.restfulwebservices.user;



import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "John", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);

    }


    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void delete(int id) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
            }
        }
    }

}
