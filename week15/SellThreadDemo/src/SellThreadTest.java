class SellThread implements Runnable {
    private int i = 5;
    String key = " ";

    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized(key) {
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->sell " + i--);
                } else {
                    break;
                }
            }
        }
    }
}

public class SellThreadTest {

    public static void main(String[] args) {
        SellThread sell = new SellThread();
        Thread sell1 = new Thread(sell, "sellman1");
        Thread sell2 = new Thread(sell, "sellman2");
        Thread sell3 = new Thread(sell, "sellman3");
        sell1.start();
        sell2.start();
        sell3.start();
    }
}
