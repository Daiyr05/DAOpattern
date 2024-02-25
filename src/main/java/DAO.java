import java.sql.SQLDataException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLDataException;

    List<T> getAll() throws SQLDataException;
    int insert(T t) throws SQLDataException;

    int update(int id,T t) throws SQLDataException;

    int delete(int id) throws SQLDataException;

}
