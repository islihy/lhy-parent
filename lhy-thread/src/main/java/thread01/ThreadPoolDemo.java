package thread01;

import java.util.concurrent.*;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 16:29
 */

class MyCallable0 implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future =newCachedThreadPool.submit(new MyCallable0());

        if (!future.isDone()) System.out.printf("task is not finish , waiting");

        try {
            System.out.printf(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedThreadPool.shutdown();
        }
    }
}
