import java.io.File;

/**
 * 文件名：MyFileTest.java
 * 功能描述：File类的使用测试Demo
 */
public class MyFileTest {
    public static void main(String[] args) {
        //此处创建了一个文件对象，并非是在磁盘上创建了一个文件，且无法读取文件的内容
        File file = new File("example.txt");
        System.out.println("文件名称："+file.getName());
        System.out.println("文件路径："+file.getPath());
        System.out.println("文件绝对路径："+file.getAbsolutePath());
        System.out.println("文件父路径："+file.getParent());
        System.out.println(file.canRead()?"文件可读":"文件不可读");
        System.out.println(file.canWrite()?"文件可写":"文件不可写");
        System.out.println(file.isFile()?"是一个文件":"不是一个文件");
        System.out.println(file.isDirectory()?"是一个目录":"不是一个目录");
        System.out.println(file.isAbsolute()?"是一个绝对路径":"不是一个绝对路径");
        System.out.println("文件最后修改时间："+file.lastModified());
        System.out.println("文件大小："+file.length()+"bytes");
        System.out.println("文件删除是否成功："+file.delete());
    }
}
