import java.sql.*;

//import com.mysql.jdbc.Driver;
public class Test {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接
        //cmd mysql -uroot -p<数据库密码>
        String ur1 = "jdbc:mysql://127.0.0.1:3306/1218?useSSL=false";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(
                ur1,
                username,
                password
        );
        //System.out.println(connection);

        //3、获取执行语句 statement
        Statement statement = connection.createStatement();

        //4、执行一条语句
        String sql = "SELECT DATABASE()";
        ResultSet resultSet = statement.executeQuery(sql);

        //5、事先知道结果只有一行+一列
        resultSet.next();//调一次next才到第一行
        String name = resultSet.getString(1);//第一列从1开始
        System.out.println(name);
        //关闭结果集resultSet
        resultSet.close();

        sql = "SELECT id, username FROM users ORDER BY id";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String user = resultSet.getString(2);
            System.out.println(id + ", " + user);
        }
        resultSet.close();

        //关闭语句
        statement.close();
        //关闭连接
        connection.close();
    }
}

