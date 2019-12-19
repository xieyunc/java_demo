import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件名：ByteStreamTest.java
 * 功能描述：字节流文件读写测试
 */
public class ByteStreamTest {
    void readFile() throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("test.txt");
            int b = 0;
            while (true) {
                b = in.read(); //一次读取一个字节
                if (b == -1)
                    break;
                System.out.printf("%d ", b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
        }
    }

    void writeFile() throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("test.txt");
            String str = "Java数据写入";
            byte[] b = str.getBytes();
            for (int i = 0; i < b.length; i++) {
                out.write(b[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        ByteStreamTest test = new ByteStreamTest();
        try {
            test.writeFile();
            test.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
