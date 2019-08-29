package thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 16:17
 */

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()){
            System.out.printf("task is not finish , waiting");
        }

        System.out.printf("task return : "+task.get());
    }

}
