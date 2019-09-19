import com.sm.crm.entity.User;
import com.sm.crm.mapper.DepartmentMapper;
import com.sm.crm.mapper.RightMapper;
import com.sm.crm.mapper.RoleMapper;
import com.sm.crm.service.LogService;
import com.sm.crm.service.MenuService;
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
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RightMapper rightMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private LogService logService;

    @Test
    public void test() {
        User user = new User();
        user.setUserName("a");
//        user.setEmail("sss");
//        user.setDepaId(1L);
//        user.setGender("female");
//        user.setRealName("real");
//        user.setPhone("3924");
        user.setPassword("aa");
        user.setUid(7L);
//        userService.findAllUser(1,20).getList().forEach(item-> System.out.println(item));
        roleMapper.findRoleByUser(user).forEach(item -> System.out.println(item));
    }
}