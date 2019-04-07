import java.security.Provider;
import java.security.Security;

/**
 * @author huyue01@sinovatech.com 2019/3/26 13:14
 */
public class TestSecurity {
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for(Provider p:providers){
            System.out.println("provider name:"+p.getName());
            for(Provider.Service s:p.getServices()){
                System.out.println("类型:"+s.getType()+"，算法："+s.getAlgorithm());
            }
            System.out.println("--------------------------");
        }
    }
}
