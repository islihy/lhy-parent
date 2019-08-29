package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-19 16:02
 */
public class SyncBlockAndMethod {
    public void syncsTask(){
        synchronized (this){
            System.out.println("Hello");
        }
    }

    public synchronized void syncTask(){
        System.out.println("Hello Agin");
    }
}
