package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 15:57
 */
public class CycleWait implements Runnable{

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now ";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        t.start();
//        while (cycleWait.value ==null){
//            Thread.sleep(500);
//            System.out.println("waiting");
//        }
        t.join();
        System.out.println("value : "+ cycleWait.value);
    }
}
