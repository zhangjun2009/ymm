package local;

import common.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @author zhangj
 * @date 2019/3/21
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        try {
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();
            int userCount = userService.queryUserCount();
            assertEquals(10, userCount);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        UserService userService = new UserService();
        UserDao userDao = mock(UserDao.class);
        whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        doNothing().when(userDao).insertUser(user);
        userService.saveUser(user);
        Mockito.verify(userDao, Mockito.times(1)).insertUser(user);
    }
}