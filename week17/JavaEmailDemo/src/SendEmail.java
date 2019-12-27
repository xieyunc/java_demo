import javax.net.ssl.SSLSession;
import java.util.Properties;

/**
 * 文件名：SendEmail.java
 * 功能描述：
 */
public class SendEmail {
    public static void main(String[] args) {
        String to = "xieyunc@163.com";

        String from = "xieyunc@qq.com";

        String host = "localhost";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host",host);


    }
}
