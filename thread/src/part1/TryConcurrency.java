package part1;

import static java.lang.Thread.sleep;

/**
 * @author zhangj
 * @date 2019/7/20
 */
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(TryConcurrency::browseNews).start();
        new Thread(TryConcurrency::enjoyMusic).start();
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("enjoy the music......");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("browse the news......");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
