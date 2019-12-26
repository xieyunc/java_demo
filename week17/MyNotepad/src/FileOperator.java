/**
 * 文件名：FileOperator.java
 * 功能描述：文件读写类
 */

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class FileOperator {
    public static void main(String[] args) {
        System.out.println(selectFile("",JFileChooser.SAVE_DIALOG));
    }

	//打开文件对话框，返回已选择的文件名
    public static String selectFile(String pathFileName,int dialogType) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            //...
        }
        // 创建文件选择器
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//只允许选择文件
        fileChooser.setMultiSelectionEnabled(false);//不允许多选
        // 设置当前目录
        if (!pathFileName.equals(""))
            fileChooser.setCurrentDirectory(new File(pathFileName));
        fileChooser.setAcceptAllFileFilterUsed(false);//先取消文件过滤器

        final String[][] fileExtNames = {
                {".cvs", "CVS文件(*.cvs)"},
                {".txt", "文本文档(*.txt)"}
        };

        // 显示所有文件
        fileChooser.addChoosableFileFilter(new FileFilter() {
            public boolean accept(File file) {
                return true;
            }

            public String getDescription() {
                return "所有文件(*.*)";
            }
        });

        // 循环添加需要显示的文件
        for (final String[] fileExtName : fileExtNames) {
            fileChooser.setFileFilter(new FileFilter() {
                public boolean accept(File file) {
                    if (file.getName().toLowerCase().endsWith(fileExtName[0]) || file.isDirectory()) {
                        return true;
                    }
                    return false;
                }

                public String getDescription() {
                    return fileExtName[1];
                }
            });
        }

        fileChooser.setDialogType(dialogType);

        if (fileChooser.showDialog(null,null) ==JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getPath();
        } else {
            return "";//没有选择文件，比如取消了
        }
    }


    public static String readTxt(String path) {
        StringBuilder content = new StringBuilder("");
        try {
            String fileCharsetName = getFileCharsetName(path);
            //System.out.println("文件的编码格式为："+fileCharsetName);

            InputStream is = new FileInputStream(path);
            //必须保证此处文件编码判断无误
            InputStreamReader isr = new InputStreamReader(is, fileCharsetName);
            BufferedReader br = new BufferedReader(isr);
            BufferedReader br2 = new BufferedReader(isr);
/*
            char[] charArray = new char[8192];
            int len = 0;
            long start1 = System.currentTimeMillis();
            while((len = br2.read(charArray))>0) {
                content.append(new String(charArray,0,len));
            }
            br2.close();
            long end1 = System.currentTimeMillis();
            System.out.println("charArray:"+(end1-start1));
*/
            String str = "";
            boolean isFirst = true;
            long start2 = System.currentTimeMillis();
            while (null != (str = br.readLine())) {
                if (!isFirst)
                    content.append(System.lineSeparator());
                    //System.getProperty("line.separator");
                else
                    isFirst = false;
                content.append(str);
            }
            long end2 = System.currentTimeMillis();
            System.out.println("charArray:"+(end2-start2));

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("读取文件:" + path + "失败!");
        }
        return content.toString();
    }

    public static boolean writeTxt(String path,String fileContent,String fileCharsetName) {
        boolean saveOK = false;
        try {
            //System.out.println("文件的编码格式为："+fileCharsetName);

            OutputStream os = new FileOutputStream(path);
            //必须保证此处文件编码判断无误
            OutputStreamWriter osr = new OutputStreamWriter(os, fileCharsetName);
            BufferedWriter wr = new BufferedWriter(osr);

            //byte[] byteArray = new byte[8192];
            //int len = 0;

            wr.write(fileContent);
            wr.close();
            saveOK = true;
        } catch (Exception e) {
            //e.printStackTrace();
            System.err.println("文件存盘失败:" + path + "失败!"+e.getMessage());
        }
        return saveOK;
    }

    public static String getFileCharsetName(String fileName) throws IOException {
        String code = "UTF-8";
        try {
            code = EncodeUtils.getEncode(fileName, true);
            System.out.println(code);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    /*
    public static String getFileCharsetName(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        final int headSize = 3;
        byte[] head = new byte[headSize];
        inputStream.read(head);

        String charsetName = "GBK";//或GB2312，即ANSI
        if (head[0] == -1 && head[1] == -2 ) //0xFFFE
            charsetName = "UTF-16";
        else if (head[0] == -2 && head[1] == -1 ) //0xFEFF
            charsetName = "Unicode";//包含两种编码格式：UCS2-Big-Endian和UCS2-Little-Endian
        else if(head[0]==-27)// && head[1]==-101 && head[2] ==-98)
            charsetName = "UTF-8"; //UTF-8(不含BOM)
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
            charsetName = "UTF-8"; //UTF-8-BOM
        else
        {
            int i = 0;
            charsetName = "UTF-8 NoBom";
            while (i < headSize - 2) {
                if ((head[i] & 0x00FF) < 0x80) {// (10000000)值小于0x80的为ASCII字符
                    i++;
                    continue;
                } else if ((head[i] & 0x00FF) < 0xC0) {// (11000000)值在0x80和0xC0之间的,不是开头第一个
                    charsetName = "Not UTF-8";
                    System.err.println("文件编码错误: " + fileName + " : " + charsetName + "1000");
                    break;
                } else if ((head[i] & 0x00FF) < 0xE0) {// (11100000)此范围内为2字节UTF-8字符
                    if ((head[i + 1] & (0xC0)) != 0x8) {
                        charsetName = "Not UTF-8";
                        System.err.println("文件编码错误: " + fileName + " : " + charsetName + "1100");
                        break;
                    } else
                        i += 2;
                } else if ((head[i] & 0x00FF) < 0xF0) {// (11110000)此范围内为3字节UTF-8字符
                    if ((head[i + 1] & (0xC0)) != 0x80 || (head[i + 2] & (0xC0)) != 0x80) {
                        charsetName = "Not UTF-8";
                        System.err.println("文件编码错误: " + fileName + " : " + charsetName + "11100000" + (head[i + 1] & (0xC0)));
                        break;
                    } else
                        i += 3;
                } else {
                    charsetName = "Not UTF-8";
                    System.err.println("文件编码错误: " + fileName + " : " + charsetName + "1111");
                    break;
                }
            }
        }

        inputStream.close();

        //System.out.println(code);
        return charsetName;
    }
     */

}
