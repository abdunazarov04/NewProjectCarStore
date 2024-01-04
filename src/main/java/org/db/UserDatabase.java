package org.db;

import org.been.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> userList;

    public UserDatabase() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }



    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public boolean updateUser(User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = userList.get(i);
            if (currentUser.getId() == updatedUser.getId()) {
                userList.set(i, updatedUser);
                return true;
            }
        }
        return false;


    }
    public boolean deleteUser(int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                userList.remove(user);
                return true;
            }
        }
        return false;
    }

    // Boshqa metodlar: getUserById(), getUserByUsername(), updateUser(), deleteUser(), va hokazo
}
