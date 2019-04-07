import java.util.HashMap;
import java.util.Map;

/**
 * @author huyue01@sinovatech.com 2019/3/28 14:08
 */
public class TestSufa {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1};
        getSingle(arr);

    }

    private static void getSingle(int[] arr){
        int len  =arr.length;
        if (len<2){
            return;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <len ; i++) {
            if (map.containsKey(arr[i])){
                map.remove(arr[i]);
            }else {
                map.put(arr[i],i);
            }
        }
        for (Integer key:map.keySet()){
            System.out.println(key);
        }
    }
}
