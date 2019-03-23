package verify;

import common.User;

/**
 * @author zhangj
 * @date 2019/3/23
 */
public class UserService {
    public void saveOrUpdate(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getCount(user) > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }
}
