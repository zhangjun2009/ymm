package matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
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
    public void queryByName() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName("zhangj")).thenReturn("alex");
        UserService userService = new UserService();
        String queryByName = userService.queryByName("zhangj");
        assertEquals("alex", queryByName);

        PowerMockito.when(userDao.queryByName("chen")).thenReturn("alex");
        String chen = userService.queryByName("chen");
        assertEquals("alex", chen);

        PowerMockito.when(userDao.queryByName("li")).thenReturn("alex");
        String li = userService.queryByName("li");
        assertEquals("alex", li);
    }

    @Test
    public void queryByNameWithMatch() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName(Matchers.argThat(new MyArgumentMatcher()))).thenReturn("wwww");
        UserService userService = new UserService();
        String queryByName = userService.queryByName("zhangj");
        assertEquals(queryByName, "wwww");
    }

    static class MyArgumentMatcher extends ArgumentMatcher<String> {

        @Override
        public boolean matches(Object o) {
            String arg = (String) o;
            switch (arg) {
                case "zhangj":
                case "chen":
                case "li":
                    return true;
                default:
                    return false;
            }
        }
    }
}