package part1;

/**
 * @author zhangj
 * @date 2019/7/20
 */
public class TicketWindowTest {
    public static void main(String[] args) {
        new TicketWindow("A").start();
        new TicketWindow("B").start();
        new TicketWindow("C").start();
        new TicketWindow("D").start();
    }
}
