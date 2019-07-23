package part1;

/**
 * @author zhangj
 * @date 2019/7/20
 */
public class TicketWindow extends Thread {
    /**
     * 线程名称
     */
    private final String name;
    /**
     * 总数
     */
    private static final int MAX = 50000;

    /**
     * 顺序
     */
    private int index;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(name + "卖出第" + index++ + "个!");
        }
    }
}
