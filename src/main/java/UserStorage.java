import javax.management.relation.Role;
import java.util.ArrayList;

public class UserStorage {
    private static UserStorage instance = new UserStorage();

    public static ArrayList<Usser> allUsers;


    public UserStorage getInstance() {
        return instance;
    }

    public static ArrayList<Usser> getAllUsers() {
        return allUsers;
    }

    public boolean add(Usser usser) {
        for (Usser u : allUsers) {
            if (u.getLogin().equals(usser.getLogin()) && (usser.getPasword().equals(usser.getPasword()))) {
                return false;
            }
        }
        return allUsers.add(usser);

    }


    public <User> Role getRole(String login, String password) {
        Role result = null;
        for (Usser user1 : allUsers) {
            if (user1.getLogin().equals(login) && user1.getPasword().equals(password)) {
                result = user1.getRole();
            }
        }
        return result;
    }

}


