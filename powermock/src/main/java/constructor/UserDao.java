package constructor;

/**
 * @author zhangj
 * @date 2019/3/23
 */
public class UserDao {
    private String userName;
    private String password;

    public UserDao(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void insert() {
        throw new UnsupportedOperationException();
    }
}
