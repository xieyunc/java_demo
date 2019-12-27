import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * 文件名：GreetingServer.java
 * 功能描述：Socket测试服务端
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    public void run() {
        while(true) {
            try {
                System.out.println("等待远程连接，服务端口：" + serverSocket.getLocalPort() + "……");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("命令格式不正确，端口参数不能为空！\n正确的命令格式为：");
            System.out.println("GreetingServer <服务端口号>");
            System.out.println("如：\nGreetingServer 1813");
            return;
        }
        int port = Integer.parseInt(args[0]);
        try {
            Thread tr = new GreetingServer(port);
            tr.run();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
}
