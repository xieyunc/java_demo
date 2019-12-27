/**
 * 文件名：MyPriorityTest.java
 * 功能描述：多线程优先级功能的测试Demo
 */
class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(100); //当前线程休眠100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + (i));//输出线程名
        }
    }
}

public class MyPriorityTest {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        try {
            t1.start();
            //可以比较一下有无t1.join();语句的执行效果
            t1.join(); //等待本线程执行完毕后，才会去执行其他线程，相当提升了t1对象的优先级为最高级（10）

            for (int i = 1; i <= 5; i++) {
                Thread.sleep(100); //当前线程（即main的主线程）休眠100ms
                System.out.println(Thread.currentThread().getName() + "-->" + (i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
