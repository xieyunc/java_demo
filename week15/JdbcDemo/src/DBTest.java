import java.sql.*;
import java.text.ParseException;

/**
 * 文件名：DBTest.java
 * 功能描述：
 */
public class DBTest {
    //插入数据
    public static void saveInfo(Object[] data) throws ParseException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn= DB.getConn();
            String sql = "insert into 操作员表(操作员编号,操作员姓名,等级,密码,管理校区,注册日期) values (?,?,?,?,?,?) ";
            pstmt = DB.getPStmt(conn, sql);
            pstmt.setString(1,(String) data[0]);
            pstmt.setString(2,(String) data[1]);
            pstmt.setInt(3,(Integer) data[2]);
            pstmt.setString(4,(String) data[3]);
            pstmt.setInt(5,(Integer) data[4]);
            pstmt.setDate(6,(new java.sql.Date((Long)data[5])));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
    }

    public static void queryInfo(String sql) throws ParseException {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn= DB.getConn();
            rs = DB.executeQuery(conn,sql);

            //while(rs.next()) {
            //    System.out.println(rs.getString(1)+"|"+rs.getString(2));
            //}

            StringBuilder str = new StringBuilder("");

            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1; i < rsmd.getColumnCount(); i++) {
                str.append(rsmd.getColumnName(i)).append(",");
            }
            str.delete(str.length()-1,str.length());
            System.out.println(str);

            while(rs.next()) {
                str.delete(0,str.length());
                for (int i = 1; i < rsmd.getColumnCount();i++) {
                    if (i>1)
                        str.append(",");
                    str.append(rs.getObject(i));
                }
                System.out.println(str);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DB.closeRs(rs);
            DB.closeConn(conn);
        }
    }

    public static void main(String[] args) {

        Object[] objects = new Object[6];

        objects[0] = new String("xyfd");
        objects[1] = new String("小宇飞刀");
        objects[2] = new Integer(-1);
        objects[3] = new String("123456");
        objects[4] = new Integer(3);
        objects[5] = new java.util.Date().getTime(); //时间戳 long类型

        try {
            saveInfo(objects);
            queryInfo("select * from 操作员表");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
