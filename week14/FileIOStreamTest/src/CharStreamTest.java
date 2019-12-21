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
            System.out.println("当前文件的字符编码为："+in.getEncoding());
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
            System.out.println("当前文件的字符编码为："+out.getEncoding());
            String str = "Java数据写入！\r\n";
            out.write(str);
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
