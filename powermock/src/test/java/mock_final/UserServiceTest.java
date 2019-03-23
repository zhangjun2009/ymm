package mock_final;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author zhangj
 * @date 2019/3/22
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
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

    @Test
    public void queryUserCountWithPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService userService = new UserService(uDao);
        int userCount = userService.queryUserCount();
        assertEquals(10, userCount);
    }


}