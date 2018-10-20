import com.ljb.annotion.DescBean;
import com.ljb.cache.JedisPoolUtil;
import com.ljb.dao.*;
import com.ljb.entity.*;
import com.ljb.service.SysMenuService;
import com.ljb.service.SystemService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.SHA256Util;
import com.ljb.utils.ZTree;
import org.apache.velocity.runtime.directive.Foreach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/11<br>
 * 描述: <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class InitSystem {
    @Autowired
    private SystemService systemService;

    @Test
    public void init(){
        systemService.initSystem();
    }

}
