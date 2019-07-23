package part1;

/**
 * 模板设计模式
 *
 * @author zhangj
 * @date 2019/7/20
 */
public class TempleteMethod {
    public final void print(String message) {
        System.out.println("=====================");
        wrapPrint(message);
        System.out.println("=====================");
    }

    public void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TempleteMethod method1 = new TempleteMethod() {
            @Override
            public void wrapPrint(String message) {
                System.out.println(message);
            }
        };
        method1.print("method1");

        TempleteMethod method2 = new TempleteMethod() {
            @Override
            public void wrapPrint(String message) {
                System.out.println(message);
            }
        };
        method1.print("method2");
    }
}
