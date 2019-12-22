/**
 * 文件名：MySynchronizedTest.java
 * 功能描述：线程同步关键字synchronized的用法测试Demo
 */
public class MySynchronizedTest {
    private int shareInt = 0;
    class AddThread extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (MySynchronizedTest.this) { //对以下代码块加锁，代码块执行完毕，释放该锁
                System.out.println("当前线程："+Thread.currentThread().getName());//输出线程名
                try {
                    System.out.println("自增之前，shareInt="+shareInt);
                    Thread.sleep(100); //当前线程休眠100ms
                    shareInt ++;
                    System.out.println("自增之后，shareInt="+shareInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class SubThread extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (MySynchronizedTest.this) { //对以下代码块加锁，代码块执行完毕，释放该锁
                System.out.println("当前线程："+Thread.currentThread().getName());//输出线程名
                try {
                    System.out.println("自减之前，shareInt="+shareInt);
                    Thread.sleep(100); //当前线程休眠100ms
                    shareInt --;
                    System.out.println("自减之后，shareInt="+shareInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MySynchronizedTest() {
        Thread t1 = new AddThread();
        Thread t2 = new SubThread();
        t1.start();
        t2.start();
/*
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(100); //当前线程（即main的主线程）休眠100ms
                System.out.println(Thread.currentThread().getName() + "-->" + (i));
            }
*/
    }

    public static void main(String[] args) throws InterruptedException {
        MySynchronizedTest test = new MySynchronizedTest();
    }
}
