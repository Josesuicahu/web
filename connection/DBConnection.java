package connection;
import com.google.gson.Gson;

/**
 *
 * @author Dafne
 */
public class DBConnection{
    
    protected static final String HOST = "JDBC:MYSQL://localhost:3306/guerrilla";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "root";
    protected static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    protected final Gson GSON;

    public DBConnection() {
        this.GSON = new Gson();
    }
}
