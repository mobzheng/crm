import com.sm.crm.entity.User;
import com.sm.crm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test01 {

    @Autowired
    private UserService userService;
    @Test
    public void test(){
        User user = new User();
        user.setUid(1L);
        System.out.println(userService.findUser(user));
    }
}
