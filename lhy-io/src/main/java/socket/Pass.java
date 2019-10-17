package socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-27 01:49
 */
public class Pass {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(10012);
        byte[] msg = new byte[2];
        System.out.println("服务器准备就绪.......");
        Socket client = server.accept();
        System.out.println("…连接成功…");
        InputStream in = new DataInputStream(client.getInputStream());
        in.read(msg);
        for(int i=0;i<msg.length;i++) {
            System.out.println(msg[i]);
        }
        in.close();
        client.close();
        server.close();
    }

}
