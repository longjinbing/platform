import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BaseTest {

    private static final Logger logger= LoggerFactory.getLogger(BaseTest.class);

    /**
     * wac
     */
    @Autowired
    private WebApplicationContext wac;

    /**
     * MockMvc
     */
    private MockMvc mockMvc;

    protected WebApplicationContext getWac()
    {
        return this.wac;
    }

    protected MockMvc getMockMvc()
    {
        return this.mockMvc;
    }

}
