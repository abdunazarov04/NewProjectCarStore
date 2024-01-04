package org.db;

import org.service.User;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private Map<Integer, User> userMap;

    public UserDatabase() {
        this.userMap = new HashMap<>();
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUserById(int userId) {
        return userMap.get(userId);
    }

    public User getUserByUsername(String username) {
        for (User user : userMap.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }




    public boolean updateUser(User updatedUser) {
        if (userMap.containsKey(updatedUser.getId())) {
            userMap.put(updatedUser.getId(), updatedUser);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int userId) {
        if (userMap.containsKey(userId)) {
            userMap.remove(userId);
            return true;
        }
        return false;
    }
}
