import com.ljb.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/11<br>
 * 描述: <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestShiro {
    @Autowired
    private AccountService accountService;

    @Test
    public void permaission(){
      /*List<String> list=accountService.roles(15);
        for(String role:list){
            System.out.println(role);
        }*/
        List<String> permissions=accountService.permissions(15);
        for(String permission:permissions){
            System.out.println(permission);
        }
    }
}

