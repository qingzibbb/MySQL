import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.1:3306/20_0210?useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url,user,password);


        /*Statement statement = connection.createStatement();
        String sql = "INSERT INTO users (id,name) VALUES (3,'王琑')";
        statement.executeUpdate(sql);
        statement.close();*/

        /*Statement statement = connection.createStatement();
        String sql = "UPDATE users SET name = '儿啊' WHERE id = 3";
        statement.executeUpdate(sql);
        statement.close();*/

        /*Statement statement = connection.createStatement();
        String sql = "DELETE FROM users WHERE id = 3";
        statement.executeUpdate(sql);
        statement.close();*/

        {
            Statement statement = connection.createStatement();
            String sql = "SELECT id,name FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            List<String> nameList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                nameList.add(name);
                System.out.println(id + "," + name);
            }
            resultSet.close();
            statement.close();
            System.out.println(nameList);
        }
        connection.close();
    }
}



