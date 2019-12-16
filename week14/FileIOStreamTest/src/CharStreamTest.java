import java.io.*;

/**
 * 文件名：CharStreamTest.java
 * 功能描述：字符流文件读写测试
 */
public class CharStreamTest {
    void readFile() throws IOException {
        FileReader in = null;
        try {
            in = new FileReader("test.txt");
            int b = 0;
            while (true) {
                b = in.read(); //一次读取一个字符
                if (b == -1)
                    break;
                System.out.printf("%c", b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
        }
    }

    void writeFile() throws IOException {
        FileWriter out = null;
        try {
            out = new FileWriter("test.txt");
            String str = "Java数据写入";
            out.write(str);
            out.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        CharStreamTest test = new CharStreamTest();
        try {
            test.writeFile();
            test.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
