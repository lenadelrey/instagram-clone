package by.instagram.storage;

import by.instagram.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static List<User> users = new ArrayList<>();
    private long count = 0;
    private static List<User> friends = new ArrayList<>();

    public void save(User user) {
        users.add(user);
        user.setId(count++);
    }

    public boolean addFriend(User user) {

        return friends.add(user);
    }

    public boolean deleteFriend(User user) {
        return friends.remove(user);
    }

    public User findById(long id) {
        for (User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByLogin(String login) {
        for (User user : users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return users;
    }

    public boolean contains(String login) {
        for (User user : users) {
            if(user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(User user) {
        for (User user1 : users) {
            if(user1.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(long id) {
        for (User user : users) {
            if(user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean containsPost(User user) {
        for (User user1 : users) {
            if(user1.equals(user) && user.getPosts().size() != 0) {
                return true;
            }
        }
        return false;
    }
}
