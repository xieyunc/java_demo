import sun.awt.CharsetString;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 文件名：ByteStreamTest.java
 * 功能描述：字节流文件读写测试
 */
public class ByteStreamTest {

    public static String getFileCharsetName(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        byte[] head = new byte[3];
        inputStream.read(head);
        String code = "GBK";//或GB2312，即ANSI
        if (head[0] == -1 && head[1] == -2 ) //0xFFFE
            code = "UTF-16";
        else if (head[0] == -2 && head[1] == -1 ) //0xFEFF
            code = "Unicode";//包含两种编码格式：UCS2-Big-Endian和UCS2-Little-Endian
        else if(head[0]==-27 && head[1]==-101 && head[2] ==-98)
            code = "UTF-8"; //UTF-8(不含BOM)
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
            code = "UTF-8"; //UTF-8-BOM

        inputStream.close();

        System.out.println(code);
        return code;
    }

    void readFile() throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("test.txt");
            int b = 0;
            /*
            while (true) {
                b = in.read(); //一次读取一个字节
                if (b == -1)
                    break;
                System.out.printf("%d ", b);
            }
            */
            String charsetName = getFileCharsetName("test.txt");

            int fileSize = in.available(); //文件大小：单位为byte
            int len;
            byte[] byteArray = new byte[fileSize];
            len = in.read(byteArray);
            String str = new String(byteArray,charsetName);//转换为string之前，必须知道读取到字节数组中的内容之前是何字符编码
            System.out.println(str);

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
            //因为是以字节流的形式输出数据，故无法设置文件的编码格式，其文件编码为默认的字符编码格式，
            // 即：Charset.defaultCharset();

            System.out.println("当前文件的编码格式为："+Charset.defaultCharset());

            String str = "Java数据写入！\r\n";
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
            //test.writeFile();
            test.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
