import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件名：JdbcDemo.java
 * 功能描述：
 */
public class JdbcDemo {
    public static void main(String[] args) {
        String driveName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String url = "jdbc:sqlserver://172.18.4.13:1433;DatabaseName=jfgl_new";
        String userName = "jfgl_sa";
        String userPassword = "q1w2E#R$";

        try {
            Class.forName(driveName);
            System.out.println("驱动程序加载成功！");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱动程序加载失败！");
        }

        try {
            Connection dbConn = DriverManager.getConnection(url,userName,userPassword);
            System.out.println("数据库连接成功！");

            final String sql = "select * from 操作员表";
            PreparedStatement statement = null;
            statement = dbConn.prepareStatement(sql);
            ResultSet rs = null;
            rs = statement.executeQuery();

            //while(rs.next()) {
            //    System.out.println(rs.getString(1)+"|"+rs.getString(2));
            //}

            StringBuilder str = new StringBuilder("");

            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1;i < rsmd.getColumnCount();i++) {
                str.append(rsmd.getColumnName(i)).append(",");
            }
            str.delete(str.length()-1,str.length());
            System.out.println(str);

            while(rs.next()) {
                str.delete(0,str.length());
                for (int i = 1; i < rsmd.getColumnCount();i++) {
                    str.append(rs.getObject(i)).append(",");
                }
                str.delete(str.length()-1,str.length());
                System.out.println(str);
            }

            rs.close();
            statement.close();
            dbConn.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }

    }
}
