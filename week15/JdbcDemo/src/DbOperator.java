import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbOperator {
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://172.18.4.13:1433;DatabaseName=xyfd_db";
    private static String dbUser = "xyfd";
    private static String dbPwd = "a1b2C#D$";

    private static Connection conn = null;

    static {
        try {
            Class.forName(driverName);
            //System.out.println("数据库驱动加载OK!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean connDB() {
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPwd);
            //System.out.println("数据库连接OK!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void queryCzyb() {
        try {
            Statement statement = conn.createStatement();
            String sql = "select * from czy";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString("userPwd"));
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertCzyb(String userId,String userName,String userPwd) {
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("insert into czy(userId,userName,userPwd) values('%s','%s','%s')",userId,userName,userPwd);

            int iRuesult = statement.executeUpdate(sql);
            System.out.println("SQL执行完毕！"+iRuesult+"条记录受到影响！");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateCzyb(String sql) {
        try {
            Statement statement = conn.createStatement();

            int iRuesult = statement.executeUpdate(sql);
            System.out.println("SQL执行完毕！"+iRuesult+"条记录受到影响！");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteCzyb(String userId) {
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("delete from czy where userId='%s'",userId);

            int iRuesult = statement.executeUpdate(sql);
            System.out.println("SQL执行完毕！"+iRuesult+"条记录受到影响！");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean czyExits(String userId) {
        int iResult = 0;
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("select count(*) from czy where userId='%s'",userId);

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            iResult = rs.getInt(1);

            rs.close();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return iResult>0;

    }

    public static boolean checkUser(String userId,String userPwd) {
        int iResult = 0;
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("select count(*) from czy where userId='%s' and userPwd='%s'",userId,userPwd);

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            iResult = rs.getInt(1);

            rs.close();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return iResult>0;

    }
}
