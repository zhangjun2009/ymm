package constructor;

/**
 * @author zhangj
 * @date 2019/3/23
 */
public class UserService {
    public void save(String userName, String password) {
        UserDao userDao = new UserDao(userName, password);
        userDao.insert();
    }
}
