import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/lesson";
    private static final String userName = "postgres";
    private static final String password = "Dias2005";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,userName,password);
        }catch (Exception e){
            System.out.println(e);
        }

        return connection;
    }
}
