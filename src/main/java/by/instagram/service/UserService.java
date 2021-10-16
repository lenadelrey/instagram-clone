package by.instagram.service;

import by.instagram.entity.User;
import by.instagram.storage.UserStorage;

import java.util.List;

public class UserService {

    private UserStorage userStorage = new UserStorage();

    public boolean save(User user) {
        if(userStorage.contains(user.getLogin())) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    public boolean addFriend(User user) {
        if(userStorage.contains(user)) {
            return userStorage.addFriend(user);
        }
        return false;
    }

    public boolean deleteFriend(User user) {
        if(userStorage.contains(user)) {
            return userStorage.deleteFriend(user);
        }
        return false;
    }

    public User findById(long id) {
        if(userStorage.contains(id)) {
            return userStorage.findById(id);
        }
        return null;
    }

    public User findByLogin(String login) {
        if(userStorage.contains(login)) {
            return userStorage.findByLogin(login);
        }
        return null;
    }

    public List<User> getAll() {
        return userStorage.getAll();
    }
}
