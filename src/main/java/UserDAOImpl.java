import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{


    @Override
    public User get(int id) throws SQLDataException {
        User user = null;
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM person WHERE id = %s;", id);
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                user = new User(resultSet.getInt("id"),resultSet.getString("login"),resultSet.getString("password"));
            }
        }catch (Exception e){

        }
        return user;
    }

    @Override
    public List<User> getAll() throws SQLDataException {
        ArrayList<User> arr = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM person;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                arr.add(new User(resultSet.getInt("id"),resultSet.getString("login"),resultSet.getString("password")));
            }
        }catch (Exception e){

        }
        return arr;
    }

    @Override
    public int insert(User user) throws SQLDataException {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO person(login, password) VALUES ('%s','%s')",user.getLogin(),user.getPassword());
            statement.executeUpdate(query);
        }catch (Exception e){

        }
        return user.getId();
    }

    @Override
    public int update(int id,User user) throws SQLDataException {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE person SET login = '%s', password = '%s' WHERE id = %s",user.getLogin(),user.getPassword(),id);
            statement.executeUpdate(query);
        }catch (Exception e){

        }
        return user.getId();
    }

    @Override
    public int delete(int id) throws SQLDataException {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM person WHERE id = %s",id);
            statement.executeUpdate(query);
        }catch (Exception e){

        }
        return id;
    }
}
