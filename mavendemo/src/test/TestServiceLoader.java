
import com.huyue.bean.User;
import com.huyue.service.UserService;

import java.util.ServiceLoader;

/**
 * @author huyue01@sinovatech.com 2019/4/5 18:49
 */
public class TestServiceLoader {
    public static void main(String[] args) {
        ServiceLoader<UserService> serviceServiceLoader =ServiceLoader.load(UserService.class);
        for (UserService service:serviceServiceLoader){
            System.out.println(service.insert(new User()));
        }
    }
}
