package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 15:30
 */
public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println("Thread start : "+this.name+",i="+i);
        }
    }
}
