package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-19 11:21
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable interruptRunnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try{
                    //程序运行时，经常检查本线程中断标志位，如果被设置了自动标志位就自动停止线程
                    while (!Thread.currentThread().isInterrupted()){
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName()+"("+Thread.currentThread().getState()+") loop"+i);
                    }
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+"("+Thread.currentThread().getState()+") catch InterruptedException ");
                }
            }
        };

        Thread t1 = new Thread (interruptRunnable,"t1");
        System.out.println(t1.getName()+"("+t1.getState()+") is new ");
        t1.start();
        System.out.println(t1.getName()+"("+t1.getState()+") is started ");


        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName()+"("+t1.getState()+") is interrupted ");


        Thread.sleep(300);
        System.out.println(t1.getName()+"("+t1.getState()+") is interrupted now ");

    }

}
