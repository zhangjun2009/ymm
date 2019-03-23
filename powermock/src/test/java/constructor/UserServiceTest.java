package constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author zhangj
 * @date 2019/3/23
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void save() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        String userName = "zhangj";
        String password = "qaz";
        PowerMockito.whenNew(UserDao.class).withArguments(userName, password).thenReturn(userDao);
        PowerMockito.doNothing().when(userDao).insert();
        UserService userService = new UserService();
        userService.save(userName, password);
        Mockito.verify(userDao).insert();
    }
}