package hello_world;

import common.User;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

/**
 * @author zhangj
 * @date 2019/3/21
 */
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Ignore
    @Test
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int userCount = userService.queryUserCount();
        assertEquals(10, userCount);
    }

    @Ignore
    @Test
    public void queryUserCountWithPowerMock() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        UserService userService = new UserService(userDao);
        int userCount = userService.queryUserCount();
        assertEquals(10, userCount);
    }

    @Test
    public void saveUserWithPowerMock() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        UserService userService = new UserService(userDao);
        User user = new User();
        PowerMockito.doNothing().when(userDao).insertUser(user);
        userService.saveUser(user);
        Mockito.verify(userDao).insertUser(user);
    }
}