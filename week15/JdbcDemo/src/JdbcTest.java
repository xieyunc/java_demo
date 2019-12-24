import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest {
    public static void main(String[] args) {

        if (!DbOperator.connDB() ) {
            return;
        }

        DbOperator.queryCzyb();
        System.out.println("----------------------------------");

        if (!DbOperator.czyExits("xxx")) //如果某操作员不存在，新增该操作员
            DbOperator.insertCzyb("xxx","张三丰","123456");
        DbOperator.queryCzyb();
        System.out.println("----------------------------------");

        String sql = "update czy set userName='小李飞刀' where userId='xyfd'";
        DbOperator.updateCzyb(sql);
        DbOperator.queryCzyb();
        System.out.println("----------------------------------");

        DbOperator.deleteCzyb("xxxx");
        DbOperator.queryCzyb();
        System.out.println("----------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userId = input.nextLine();

        System.out.print("请输入用户密码：");
        String userPwd = input.nextLine();

        input.close();

        if (DbOperator.checkUser(userId,userPwd)) {
            System.out.println("用户身份验证OK!");
        } else {
            System.out.println("用户身份验证失败!");
        }

    }
}
