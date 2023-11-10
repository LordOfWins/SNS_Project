package org.springstudy.restfulweb.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

  public static List<User> users = new ArrayList<>();

  static {
    users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
    users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
    users.add(new User(3, "Jack", LocalDate.now().minusYears(20)));
  }

  public List<User> findAll() {
    return users;
  }

  public User save(User user) {
    user.setId(users.size() + 1);
    users.add(user);
    return user;
  }

  public User findUser(Integer id) {
    Predicate<User> predicate = user -> user.getId().equals(id);
    return users.stream().filter(predicate).findFirst().orElse(null);
  }
}
