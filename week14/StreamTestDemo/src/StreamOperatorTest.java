import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件名：StreamOperatorTest.java
 * 功能描述：测试文件
 */
public class StreamOperatorTest {
    public static void main(String[] args) {
        StreamOperator streamTest = new StreamOperator();

        //获取*.class文件所在的目录
        String path = StreamOperatorTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //System.out.println(path);
        //System.out.println(System.getProperty("user.dir"));

        String sFileName = path+"回到明朝当王爷.txt";
        String fileName = path+"*结果文件.txt";
        String dFileName;

        try {
            long fileSize = new FileInputStream(sFileName).available();
            System.out.printf("源文件大小为：%,d Byte！字符编码为：%s \n",fileSize,StreamOperator.getFileCharsetName(sFileName));
            dFileName = fileName.replace("*","字节流复制");
            streamTest.CopyFileByByteStream(sFileName,dFileName);

            dFileName = fileName.replace("*","字节缓存流复制");
            streamTest.CopyFileByByteBufferedStream(sFileName,dFileName);

            dFileName = fileName.replace("*","字符流复制");
            streamTest.CopyFileByCharStream(sFileName,dFileName);

            dFileName = fileName.replace("*","字符缓存流复制");
            streamTest.CopyFileByCharBufferedStream(sFileName,dFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
