import java.sql.*;
import java.util.Scanner;

public class JdbcTest {
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://172.18.4.13:1433;DatabaseName=xyfd_db";
    private static String userName = "xyfd";
    private static String userPwd = "q1w2E#R$";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName(driverName);
            System.out.println("驱动程序加载OK！");

            conn = DriverManager.getConnection(url, userName, userPwd);//连接数据库
            System.out.println("数据库连接成功！");

            Scanner input = new Scanner(System.in);
            System.out.print("请输入用户名：");
            String aUser = input.nextLine();

            System.out.print("请输入用户密码：");
            String aPwd = input.nextLine();

            String sql = String.format("select count(*) from Users where userId='%s' and userPassword='%s'",aUser,aPwd);

            statement = conn.createStatement();

            rs = statement.executeQuery(sql);

            rs.next();
            int recordCount = rs.getInt(1);

            if (recordCount>0)
                System.out.println("验证通过！");
            else
                System.out.println("验证失败！");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //statement.close();
            //conn.close();
        }

    }
}
