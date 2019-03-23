package answer;

/**
 * @author zhangj
 * @date 2019/3/23
 */
public class UserService {
    public String queryByName(String name) {
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}
