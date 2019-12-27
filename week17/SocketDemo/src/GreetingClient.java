import java.io.*;
import java.net.Socket;

/**
 * 文件名：GreetingClient.java
 * 功能描述：Socket测试客户端
 */
public class GreetingClient {
    public static void main(String[] args) {
        if (args.length<2) {
            System.out.println("命令格式不正确，服务器地址和端口参数不能为空！\n正确的命令格式为：");
            System.out.println("GreetingClient <远程服务器地址> <服务端口号>");
            System.out.println("如：\nGreetingClient 127.0.0.1 1813");
            return;
        }

        String serverName = args[0]; //服务器地址
        int port = Integer.parseInt(args[1]); //服务端口号
        try {
            System.out.println("连接到主机："+serverName+"，端口号："+port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址："+client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from "+client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应："+in.readUTF());
            client.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
