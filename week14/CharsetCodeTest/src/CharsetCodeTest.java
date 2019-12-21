/**
 * 文件名：CharsetCodeTest.java
 * 功能描述：文件字符编码测试
 */

import java.io.*;

public class CharsetCodeTest {
    public static void main(String[] args) throws Exception {
        String filePath = "test.txt";
        String content = readTxt(filePath);
        System.out.println(content);
    }

    public static String readTxt(String path) {
        StringBuilder content = new StringBuilder("");
        try {
            String fileCharsetName = getFileCharsetName(path);
            System.out.println("文件的编码格式为："+fileCharsetName);

            InputStream is = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(is, fileCharsetName);
            BufferedReader br = new BufferedReader(isr);

            String str = "";
            boolean isFirst = true;
            while (null != (str = br.readLine())) {
                if (!isFirst)
                    content.append(System.lineSeparator()); //System.getProperty("line.separator");
                else
                    isFirst = false;
                content.append(str);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("读取文件:" + path + "失败!");
        }
        return content.toString();
    }


    public static String getFileCharsetName(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        byte[] head = new byte[3];
        inputStream.read(head);

        String charsetName = "GBK";//或GB2312，即ANSI
        if (head[0] == -1 && head[1] == -2 ) //0xFFFE
            charsetName = "UTF-16";
        else if (head[0] == -2 && head[1] == -1 ) //0xFEFF
            charsetName = "Unicode";//包含两种编码格式：UCS2-Big-Endian和UCS2-Little-Endian
        else if(head[0]==-27 && head[1]==-101 && head[2] ==-98)
            charsetName = "UTF-8"; //UTF-8(不含BOM)
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
            charsetName = "UTF-8"; //UTF-8-BOM

        inputStream.close();

        //System.out.println(charsetName);
        return charsetName;
    }
}