package answer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author zhangj
 * @date 2019/3/23
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void queryByNameWithAnswer() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName(Mockito.anyString())).then(invocation -> {
            String argument = (String) invocation.getArguments()[0];
            switch (argument) {
                case "zhang":
                    return "z";
                case "chen":
                    return "c";
                default:
                    throw new RuntimeException();
            }
        });
        UserService userService = new UserService();
        assertEquals("z", userService.queryByName("zhang"));
        assertEquals("c", userService.queryByName("chen"));

    }

}