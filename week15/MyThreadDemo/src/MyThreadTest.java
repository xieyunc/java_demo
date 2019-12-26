/**
 * 文件名：MyFirstThreadTest.java
 * 功能描述：继承Thread类，重写run()方法实现多线程功能的测试Demo
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
        for(int i = 5;i > 0; i--) {
            try {
                Thread.sleep(100); //当前线程休眠100ms
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + (i));//输出线程名
        }
    }
}

public class MyThreadTest {
    public static void main(String[] args) {
       Thread t1 = new MyThread();
       Thread t2 = new MyThread();
        t1.start();
        t2.start();
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(100); //当前线程（即main的主线程）休眠100ms
                System.out.println(Thread.currentThread().getName()+"-->"+(i));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
