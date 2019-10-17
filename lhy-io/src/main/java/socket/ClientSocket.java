package socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-27 01:50
 */
public class ClientSocket {
    public static void main(String[]args) throws Exception{

        Socket socket =new Socket("localhost",10012);
        byte [] sbyte=new byte[] {(byte)0x16,(byte)0x20};
        OutputStream os=socket.getOutputStream();
        os.write(sbyte,0,sbyte.length);
        os.flush();
        os.close();

        socket.close();
    }

}
