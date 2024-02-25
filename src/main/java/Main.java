import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDao = new UserDAOImpl();
        try{
            User user = userDao.get(1);
            System.out.println(user.toString());
            userDao.update(3,new User("Almas","boxer") );

            List<User> arr = userDao.getAll();
            for (User u : arr){
                System.out.println(u.toString());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
