import com.ljb.service.SysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/10<br>
 * 描述: <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class GeneratorMenu {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void resetMenu(){
        sysMenuService.resetMenu();
    }

}
