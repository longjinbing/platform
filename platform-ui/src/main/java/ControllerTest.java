import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class ControllerTest extends BaseTest {

    @Test
    public void request() {
        String url = "/";
        MvcResult result = null;
        try {
            getMockMvc().perform(MockMvcRequestBuilders.request(HttpMethod.GET, url));
        }catch (Exception e){

        }
    }

}
