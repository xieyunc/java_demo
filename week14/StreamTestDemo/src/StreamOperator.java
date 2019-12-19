import java.io.*;

/**
 * 文件名：StreamOperator.java
 * 功能描述：流操作类文件
 */
public class StreamOperator {
    private final int BUF_SIZE = 10; //为演示效果，故意把缓存设置得很小，正常一般为1024的倍数

    //-----------------字节流文件复制方法---------------//
    void CopyFileByByteStream(String sFileName,String dFileName) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        long byteStart = System.currentTimeMillis();//获取系统当前时间戳
        try {
            fis = new FileInputStream(sFileName);
            fos = new FileOutputStream(dFileName);

            int hasRead = 0;

            byte[] byteArray = new byte[BUF_SIZE];

            while ((hasRead = fis.read(byteArray))>0) {
                fos.write(byteArray,0,hasRead);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                fis.close();
            if (fos != null)
                fos.close();
            long byteEnd = System.currentTimeMillis();
            System.out.println("字节流复制文件完毕！共花费"+(byteEnd-byteStart)+"毫秒。");
        }

    }

    //-----------------字节流+缓存流文件复制方法---------------//
    void CopyFileByByteBufferedStream(String sFileName,String dFileName) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        long byteStrat = System.currentTimeMillis();
        try {
            fis = new FileInputStream(sFileName);
            fos = new FileOutputStream(dFileName);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int hasRead = 0;
            byte[] bufArray = new byte[BUF_SIZE];
            while ((hasRead = bis.read(bufArray))>0) {
                bos.write(bufArray,0,hasRead);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
            if (fis != null)
                fis.close();
            if (fos != null)
                fis.close();

            long byteEnd = System.currentTimeMillis();
            System.out.println("字节流+缓存流复制文件完毕！共花费"+(byteEnd-byteStrat)+"毫秒。");
        }
    }

    //-----------------字符流文件复制方法---------------//
    void CopyFileByCharStream(String sFileName,String dFileName) throws IOException {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        long charStart = System.currentTimeMillis();
        try {
            String charsetName = getFileCharsetName(sFileName);
            reader = new InputStreamReader(new FileInputStream(sFileName),charsetName);
            writer = new OutputStreamWriter(new FileOutputStream(dFileName),charsetName);

            //fileReader = new FileReader(isr);
            //fileWriter = new FileWriter(dFileName);

            int hasRead = 0;
            char[] charArray = new char[BUF_SIZE];
            while ((hasRead = reader.read(charArray))>0) {
                writer.write(charArray,0,hasRead);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
            long charEnd = System.currentTimeMillis();
            System.out.println("字符流复制文件完毕！共花费"+(charEnd-charStart)+"毫秒。");
        }
    }

    //-----------------字符流+缓存流文件复制方法---------------//
    void CopyFileByCharBufferedStream(String sFileName,String dFileName) throws IOException {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        long charStart = System.currentTimeMillis();
        try {
            String charsetName = getFileCharsetName(sFileName);
            reader = new InputStreamReader(new FileInputStream(sFileName),charsetName);
            writer = new OutputStreamWriter(new FileOutputStream(dFileName),charsetName);

            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);

            int hasRead = 0;
            char[] charArray = new char[BUF_SIZE];
            while ((hasRead = bufferedReader.read(charArray))>0) {
                bufferedWriter.write(charArray,0,hasRead);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
            if (bufferedReader != null)
                bufferedReader.close();
            if (bufferedWriter != null)
                bufferedWriter.close();
            long charEnd = System.currentTimeMillis();
            System.out.println("字符流+缓存流复制文件完毕！共花费"+(charEnd-charStart)+"毫秒。");
        }
    }

    /**
     * 获取文本文件的编码格式
     * @param fileName :file
     * @return 文件编码格式
     * @throws IOException
     */
    public static String getFileCharsetName(String fileName) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }
}
