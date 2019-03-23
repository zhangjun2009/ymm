package mockstatic;

import common.User;

/**
 * @author zhangj
 * @date 2019/3/21
 */
public class UserService {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
