package spy;

/**
 * @author zhangj
 * @date 2019/3/23
 */
public class UserService {
    public void foo() {
        log();
    }

    private void log() {
        System.out.println("I am console log.");
    }

    public boolean exist(String name) {
        return checkExist(name);
    }

    private boolean checkExist(String name) {
        throw new UnsupportedOperationException();
    }
}
