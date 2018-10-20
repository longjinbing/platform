import com.ljb.dao.RegionDao;
import com.ljb.dao.SysMenuDao;
import com.ljb.dao.SysUserDao;
import com.ljb.dao.TableDao;
import com.ljb.entity.Region;
import com.ljb.entity.SysUser;
import com.ljb.example.SysUserExample;
import com.ljb.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/10<br>
 * 描述: <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class DaoTest {

    @Autowired
    RegionDao regionDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private TableDao tableDao;

    @Autowired
    SysUserService sysUserService;

    @Test
    public void testUion(){
      /*List<Map<String,Object>> regions=regionDao.schoolList();
        List<Map<String,Object>> colleges=regionDao.collegeList();*/
        List<Map<String,Object>> cteachers=regionDao.teacherList();
    }

    @Test
    public void testRedisCache(){
        Map<String,Object> map=new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 10);
        for (int i=0;i<20;i++){
            System.out.println("结果："+sysUserService.selectList(map));
        }
    }

    @Test
    public void testMapList(){
        Map<String,Object> map=new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 10);
        for (int i=0;i<20;i++){
            System.out.println("结果："+sysUserDao.selectMapList(map).size());
        }
    }

    @Test
    public void TestMapper(){

       Map<String,Object> map=new HashMap<>();
       map.put("limit",10);
       map.put("offset", 10);
       tableDao.queryTotal(map);
        List<SysUser> list= sysUserDao.selectByExample(null);
        SysUserExample sysUserExample=new SysUserExample();
        sysUserExample.createCriteria().andIdEqualTo(1);
        sysUserDao.selectByExample(sysUserExample);
        System.out.println(sysUserDao.selectByExample(sysUserExample));
    }

}
