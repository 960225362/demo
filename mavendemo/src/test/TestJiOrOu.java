import java.util.Arrays;
import java.util.Scanner;

/**
 * @author huyue01@sinovatech.com 2019/3/31 14:41
 */
public class TestJiOrOu {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
//            System.out.println(num % 2 != 0);
            System.out.println((num&1)!=0);
        }

    }
}
