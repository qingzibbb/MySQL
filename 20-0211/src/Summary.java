import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import javax.sql.DataSource;

public class Summary {
    public static void main(String[] args) throws SQLException {
        insert();
    }

    private static void insert() throws SQLException {
        String sql = "INSERT INTO users (username,password) VALUES (?,?)";
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("20_0211");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        DataSource dataSource = mysqlDataSource;

        try (java.sql.Connection connection = dataSource.getConnection()){
            try (PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1,"百香果");
                statement.setString(2,"123");
                statement.executeUpdate();
                try (ResultSet rs = statement.getGeneratedKeys()){
                    rs.next();
                    int id = rs.getInt(1);
                    System.out.println(id+"百香果123");
                }
            }
        }
    }

}
