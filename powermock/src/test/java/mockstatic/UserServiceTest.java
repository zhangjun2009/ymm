package mockstatic;

import common.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @author zhangj
 * @date 2019/3/21
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        PowerMockito.mockStatic(UserDao.class);
        UserService userService = new UserService();
        PowerMockito.when(UserDao.getCount()).thenReturn(10);
        int userCount = userService.queryUserCount();
        assertEquals(10, userCount);
    }

    @Test
    public void saveUser() {
        PowerMockito.mockStatic(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveUser(user);
        PowerMockito.verifyStatic();
    }
}