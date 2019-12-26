/**
 * 文件名：RunnableTest.java
 * 功能描述：使用Runnable接口实现Thread功能的测试Demo
 */
class RunThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.currentThread().sleep(100);//Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        Runnable rt1 = new RunThread();
        Runnable rt2 = new RunThread();

        Thread t1 = new Thread(rt1,"线程1");
        Thread t2 = new Thread(rt2,"线程2");

        t1.start();
        t2.start();
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
