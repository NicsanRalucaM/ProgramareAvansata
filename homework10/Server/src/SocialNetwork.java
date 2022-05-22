import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocialNetwork implements Serializable {
    private List<User> users;

    public SocialNetwork() {
        users = Collections.synchronizedList(new ArrayList<>());
    }

    public void printUserState() {
        for (User user : users) {
            System.out.print(user.isOnline() + " ; ");
            System.out.println("");
        }
    }

    public boolean checkIfAllUsersAreDisconnected() {
        for (User user : users) {
            if (user.isOnline()) {
                return false;
            }
        }
        return true;
    }


    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public boolean hasUsername(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public User getByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean getOnlineStatus(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user.isOnline();
            }
        }
        return false;
    }

    public void setOffline(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                user.setOnlineStatus(false);
            }
        }
    }

    public void setOnline(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                user.setOnlineStatus(true);
            }
        }
    }


    public void showUsers() {
        System.out.print("Current users: [ ");
        for (User user : users) {
            System.out.print(user.getName() + " ");
        }
        System.out.print("] \n");
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
}
