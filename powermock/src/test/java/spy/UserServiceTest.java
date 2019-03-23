package spy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertTrue;

/**
 * @author zhangj
 * @date 2019/3/23
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void foo() {
        UserService userService = PowerMockito.spy(new UserService());
        userService.foo();
    }

    @Test
    public void exist() throws Exception {
        UserService userService = PowerMockito.spy(new UserService());
        PowerMockito.doReturn(true).when(userService, "checkExist", "zhang");
        assertTrue(userService.exist("zhang"));
    }
}